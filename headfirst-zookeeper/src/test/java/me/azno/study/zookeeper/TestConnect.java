package me.azno.study.zookeeper;

import me.azno.study.zookeeper.zkcli.ZKConnection;
import org.junit.Before;
import org.junit.Test;

public class TestConnect {
    ZKConnection zkConnection;
    @Before
    public void before(){
        zkConnection = new ZKConnection();
    }
    @Test
    public void testConnect(){
        zkConnection.connect();
    }
}
