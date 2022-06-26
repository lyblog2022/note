package com.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitmqConfig
 *
 * @author liuyong
 * @version 1.0
 * @description com.rabbitmq.config
 * @date 2022/6/26 11:49
 */
@Configuration
public class RabbitmqConfig {
    @Bean
    protected Queue queue() {
        Queue queue = new Queue("myQueue");
        return queue;
    }
}
