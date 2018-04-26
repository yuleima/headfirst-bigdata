package me.azno.study.zookeeper.curator;


import org.apache.curator.test.TestingServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext-zk-test.xml"})
public class BasicTestWithTestingServer {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "testingServer")
    protected TestingServer testingServer;

    @Before
    public void before() {
    }

    @Test
    public void test() {

    }

    @After
    public void after() {

    }
}
