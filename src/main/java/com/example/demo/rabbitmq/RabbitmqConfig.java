package com.example.demo.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @description : rabbitmq配置文件
 */
@Configuration
public class RabbitmqConfig {
    @Autowired
    private Environment environment;

}
