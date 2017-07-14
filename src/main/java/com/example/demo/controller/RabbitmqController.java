package com.example.demo.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/4.
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitmqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/send")
    public void send() {
        String context = "hello" + new Date();
        System.out.println("Sender" + context);
        this.amqpTemplate.convertAndSend("user.email.routing-key", context);
    }

    @GetMapping("/topicExchangeSend1")
    public String topicExchangeSend1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
        return "success";
    }

    @GetMapping("/topicExchangeSend2")
    public String topicExchangeSend2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
        return "success";
    }

    @GetMapping("/fanoutExchangeSend")
    public String fanoutExchangeSend() {
        String context = "hi, fanout msg";
        System.out.println("Sender: " + context);
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
        return "success";
    }

}
