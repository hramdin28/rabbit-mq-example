package com.hanish.rabbit.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@EnableRabbit
public class RabbitMqConfig {
    private final RabbitMqProperties rabbitMqProperties;

    // Exchanges
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(rabbitMqProperties.getDirectExchange());
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(rabbitMqProperties.getTopicExchange());
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(rabbitMqProperties.getFanoutExchange());
    }

    // Queues
    @Bean
    public Queue queue1() {
        return new Queue(rabbitMqProperties.getAppQueue1());
    }

    @Bean
    public Queue queue2() {
        return new Queue(rabbitMqProperties.getAppQueue2());
    }

    // Bindings(Direct/Topic/Fanout)
    @Bean
    public Binding bindingDirectQueue1() {
        return BindingBuilder
                .bind(queue1())
                .to(directExchange())
                .with(rabbitMqProperties.getAppRoutingDirect());
    }

    @Bean
    public Binding bindingTopicQueue1() {
        return BindingBuilder
                .bind(queue1())
                .to(topicExchange())
                .with(rabbitMqProperties.getAppRoutingTopic());
    }

    @Bean
    public Binding bindingTopicQueue2() {
        return BindingBuilder
                .bind(queue2())
                .to(topicExchange())
                .with(rabbitMqProperties.getAppRoutingTopic());
    }

    @Bean
    public Binding bindingFanoutQueue1() {
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutQueue2() {
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
}
