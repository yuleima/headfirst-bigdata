package me.azno.study.zookeeper.zkcli;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKConnection {
    private String hosts = "192.168.0.189:2181";
    private static final int SESSION_TIMEOUT = 5000;
    private ZooKeeper zk;

    public void connect(){
        try {
            zk = new ZooKeeper(hosts,SESSION_TIMEOUT,new ConnWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
