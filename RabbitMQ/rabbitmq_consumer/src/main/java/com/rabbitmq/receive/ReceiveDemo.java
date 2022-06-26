package com.rabbitmq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ReceiveDemo
 *
 * @author liuyong
 * @version 1.0
 * @description com.rabbitmq.receive
 * @date 2022/6/26 11:49
 */
@Component
public class ReceiveDemo {
    @RabbitListener(queues = "myQueue")
    protected void demo(String msg) {
        System.out.println("获取到的消息：" + msg);
    }

    @RabbitListener(queues = "myQueue")
    protected void demo2(String msg) {
        System.out.println("获取到的消息22222222：" + msg);
    }

    @RabbitListener(queues = "myfanout1")
    public void demo3(String msg) {
        System.out.println("myfanout1:"+msg);
    }
    @RabbitListener(queues = "myfanout2")
    public void demo4(String msg) {
        System.out.println("myfanout2:"+msg);
    }
    @RabbitListener(queues = "topic1")
    public void demo5(String msg) {
        System.out.println("topic1:"+msg);
    }
    @RabbitListener(queues = "topic2")
    public void demo6(String msg) {
        System.out.println("topic2:"+msg);
    }
}
