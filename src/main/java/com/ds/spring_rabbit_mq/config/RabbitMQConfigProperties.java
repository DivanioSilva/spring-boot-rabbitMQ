package com.ds.spring_rabbit_mq.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "config.rabbitmq")
public class RabbitMQConfigProperties {
    private String exchange;
    private String queue;
    private String routingKey;
}
