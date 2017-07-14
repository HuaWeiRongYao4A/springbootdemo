package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @description : activemq消息生产者
 * @createTime : 2017/06/27
 */
@Service
public class ActivemqServiceImpl {
    //也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    //发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        System.out.println("从out.queue队列收到的回复报文为：" + text);
    }
}
