package me.azno.study.zookeeper.zkcli;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class ConnWatcher implements Watcher {
    private static Logger logger = LoggerFactory.getLogger(ConnWatcher.class);
    private CountDownLatch connectedSignal = new CountDownLatch(1);
    @Override
    public void process(WatchedEvent watchedEvent) {
        logger.info("process");
        // 连接建立, 回调process接口时, 其event.getState()为KeeperState.SyncConnected
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            // 放开闸门, wait在connect方法上的线程将被唤醒
            connectedSignal.countDown();
            logger.info("open connect");
        }
    }
}
