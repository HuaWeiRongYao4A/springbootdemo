package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Destription : rabbitmq发送端
 */
public class Send {
    private final static String QUEUE_NAME = "direct-hello-1";
    private final static String EXCHANGE_NAME = "exchange-1";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置rabbitmq主机名
        connectionFactory.setHost("localhost");
        //创建一个连接
        Connection connection = connectionFactory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //声明一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        //发送消息
        String message = "Hello World";
        //direct-hello为路由键
        channel.basicPublish(EXCHANGE_NAME, "direct-hello", null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
        //关闭频道和连接
        channel.close();
        connection.close();
    }
}
