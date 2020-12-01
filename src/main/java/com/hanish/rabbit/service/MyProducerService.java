package com.hanish.rabbit.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyProducerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyProducerService.class);

    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String exchange, String routingKey, String message) {
        LOGGER.info("---Topic exchange message sending---");
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }

}
