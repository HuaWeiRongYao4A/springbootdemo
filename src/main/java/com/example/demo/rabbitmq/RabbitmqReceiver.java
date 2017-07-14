package com.example.demo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Rabbitmq : 接收者1
 */
@Component
@RabbitListener(queues = "hello")
public class RabbitmqReceiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Rabbitmq Receiver-1 : " + hello);
    }
}
