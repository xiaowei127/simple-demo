package com.bise.mqdemo.sender.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: bise
 * @Date: 2019/6/14 10:28
 * @Version 1.0
 */
@Configuration
public class TopicRabbitConfig {

    /**
     * 注册队列（同时自动在Rabbit服务器创建队列）
     * @return
     */
    @Bean
    public Queue helloQueueA() {
        return new Queue("TopicHelloA" ,true);
    }

    @Bean
    public Queue helloQueueB() {
        return new Queue("TopicHelloB" ,true);
    }

    @Bean
    public Queue helloQueueC() {
        return new Queue("TopicHelloC" ,true);
    }

    @Bean
    public Queue helloQueueD() {
        return new Queue("TopicHelloD" ,true);
    }


    /**
     * 创建交换机
     * @return
     */
    @Bean
   TopicExchange helloExchange() {
        return new TopicExchange("TopicHelloExchange" ,true ,false);
    }

    /**
     * 绑定队列与交换机
     * routingKey #匹配一个或多个字符，*匹配一个字符
     * @return
     */
    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(helloQueueA()).to(helloExchange()).with("TopicHello.A");
    }
    @Bean
    Binding bindingExchangeB() {
        return BindingBuilder.bind(helloQueueB()).to(helloExchange()).with("#.TopicHello");
    }
    @Bean
    Binding bindingExchangeC() {
        return BindingBuilder.bind(helloQueueC()).to(helloExchange()).with("TopicHello.*");
    }
    @Bean
    Binding bindingExchangeD() {
        return BindingBuilder.bind(helloQueueD()).to(helloExchange()).with("*.#");
    }

}
