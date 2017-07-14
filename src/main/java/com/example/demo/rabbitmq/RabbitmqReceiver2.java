package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @rabbitmq : 接收者2
 */
@Component
@RabbitListener(queues = "fanout.B")
public class RabbitmqReceiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Rabbitmq Receiver-2 : " + hello);
    }
}
