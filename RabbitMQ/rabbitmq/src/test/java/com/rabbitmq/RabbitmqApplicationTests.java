package com.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class RabbitmqApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * provider
     */
    @Test
    void contextLoads() {
        amqpTemplate.convertAndSend("myQueue","send text312312");
        System.out.println("success");
    }

    @Test
    void contextLoads2() {
        amqpTemplate.convertAndSend("amq.fanout","core","hhhh");
        System.out.println("success");
    }

    @Test
    void contextLoads3() {
        amqpTemplate.convertAndSend("amq.topic","com.m.b","msg");
        System.out.println("success");
    }

}


