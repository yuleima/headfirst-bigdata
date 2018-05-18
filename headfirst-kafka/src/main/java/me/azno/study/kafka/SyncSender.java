package me.azno.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class SyncSender {
    private static final Logger logger = LoggerFactory.getLogger(SyncSender.class);

    public static void main(String[] args) {
        Properties props = initProps();
        String topic = "fire-and-forget-sender";
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        IntStream.range(0, 10).forEach(i -> {
            ProducerRecord<String, String> record =
                    new ProducerRecord<>(topic, String.valueOf(i), "hello " + i);
            Future<RecordMetadata> future = producer.send(record);
            try {
                RecordMetadata metadata = future.get();
                logger.info("message {} send done. partition {}, offset {}", i, metadata.partition(), metadata.offset());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });
    }

    private static Properties initProps() {
        final Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.19.30:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return props;
    }
}