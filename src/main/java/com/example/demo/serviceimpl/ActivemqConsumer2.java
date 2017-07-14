package com.example.demo.serviceimpl;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @description : activemq消息消费者
 * @createTime : 2017/06/27
 */
@Component
public class ActivemqConsumer2 {
    //使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    //将return返回的值，再发送到"out.queue"队列中
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        System.out.println(Thread.currentThread().getName() + ": Consumer-2收到的报文为：" + text );
        return "return message: " + text;
    }
}
