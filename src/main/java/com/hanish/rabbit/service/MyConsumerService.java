package com.hanish.rabbit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyConsumerService.class);

    @RabbitListener(queues = {"${app.queue1.name}"})
    public void receiveMessageForApp1(@Payload String message) {
        LOGGER.info("Consumed message queue1: {}", message);
    }

    @RabbitListener(queues = {"${app.queue2.name}"})
    public void receiveMessageForApp2(@Payload String message) {
        LOGGER.info("Consumed message queue2: {}", message);
    }

}
