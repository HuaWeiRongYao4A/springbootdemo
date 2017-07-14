package com.example.demo.serviceimpl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @description : activemq消息消费者
 * @createTime : 2017/06/27
 */
@Component
public class ActivemqConsumer {
    @JmsListener(destination = "mytest.queue")
    //该方法会异步执行，也就是说主线程会直接跳过该方法，而是使用线程池中的线程来执行该方法
    @Async
    public void receiveQueue(String text) {
        System.out.println(Thread.currentThread().getName() + ": Consumer-1收到的报文为：" + text );
    }
}
