package com.hanish.rabbit;

import com.hanish.rabbit.config.RabbitMqProperties;
import com.hanish.rabbit.service.MyProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RabbitApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(RabbitApplication.class, args);

        RabbitMqProperties rabbitMqProperties = context.getBean(RabbitMqProperties.class);
        MyProducerService myProducerService = context.getBean(MyProducerService.class);

        // Do 3 types of message exchanges
        myProducerService.sendMessage(rabbitMqProperties.getDirectExchange(),
                "direct.routing.key1",
                "Direct exchange test message");

        myProducerService.sendMessage(rabbitMqProperties.getTopicExchange(),
                "routing",
                "Topic exchange test message");

        myProducerService.sendMessage(rabbitMqProperties.getFanoutExchange(),
                null,
                "Fanout exchange test message");

    }

}
