package com.hanish.rabbit.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RabbitMqProperties {
    @Value("${exchange.direct}")
    private String directExchange;

    @Value("${exchange.topic}")
    private String topicExchange;

    @Value("${exchange.fanout}")
    private String fanoutExchange;

    @Value("${app.queue1.name}")
    private String appQueue1;

    @Value("${app.queue2.name}")
    private String appQueue2;

    @Value("${app.routing.direct}")
    private String appRoutingDirect;

    @Value("${app.routing.topic}")
    private String appRoutingTopic;
}
