package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description : activemq测试类
 * @createTime : 2017/06/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class ActivemqTest {
    @Autowired
    private Environment environment;

    @Test
    public void testEnv() {
        System.out.println(environment.getProperty("spring.datasource.url"));
    }
}
