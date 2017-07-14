package com.example.demo.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description : rabbitmq Topic Exchange配置
 */
@Configuration
public class TopicRabbitConfig {
    private final static String message = "topic.message";
    private final static String messages = "topic.messages";
    private final static String email = "user.email.routing-key";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(TopicRabbitConfig.email);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

//    @Bean TopicExchange emailExchange() {
//        return new TopicExchange("user.email.exchange");
//    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingEmailExchange(Queue emailQueue, TopicExchange exchange) {
        return BindingBuilder.bind(emailQueue).to(exchange).with("user.email.binding-key");
    }
}
