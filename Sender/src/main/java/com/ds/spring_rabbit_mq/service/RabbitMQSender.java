package com.ds.spring_rabbit_mq.service;

import com.ds.spring_rabbit_mq.config.RabbitMQConfigProperties;
import com.ds.spring_rabbit_mq.config.Records;
import com.ds.spring_rabbit_mq.domain.Employee;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RabbitMQSender {
    private final RabbitMQConfigProperties rabbitMQConfigProperties;
    private final AmqpTemplate rabbitTemplate;

    public void send(Records records){
        rabbitTemplate.convertAndSend(rabbitMQConfigProperties.getExchange(), records.getRoutingKey(), records.getContent());
        System.out.println("Send msg = " + records.getContent().toString());
    }
}
