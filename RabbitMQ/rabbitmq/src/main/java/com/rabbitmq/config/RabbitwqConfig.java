package com.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitwqConfig
 *
 * @author liuyong
 * @version 1.0
 * @description com.rabbitmq.config
 * @date 2022/6/26 11:08
 */
@Configuration
public class RabbitwqConfig {

    @Bean
    protected Queue queue() {
        Queue queue = new Queue("myQueue");
        return queue;
    }
    @Bean
    public Queue createQueue1() {
        return new Queue("myfanout1");
    }
    @Bean
    public Queue createQueue2() {
        return new Queue("myfanout2");
    }
    @Bean
    public FanoutExchange getFanout() {
        return new FanoutExchange("amq.fanout");
    }

    @Bean
    public Binding binding(Queue createQueue1,FanoutExchange getFanout){
        return BindingBuilder.bind(createQueue1).to(getFanout);
    }

    @Bean
    public Binding binding2(Queue createQueue2,FanoutExchange getFanout){
        return BindingBuilder.bind(createQueue2).to(getFanout);
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topic1");
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue("topic2");
    }
    @Bean
    public TopicExchange getTopic() {
        return new TopicExchange("amq.topic");
    }
    @Bean
    public Binding topicBinding1(Queue topicQueue1,TopicExchange getTopic){
        return BindingBuilder.bind(topicQueue1).to(getTopic).with("com.*");
    }
    @Bean
    public Binding topicBinding2(Queue topicQueue2,TopicExchange getTopic){
        return BindingBuilder.bind(topicQueue2).to(getTopic).with("com.#");
    }
}
