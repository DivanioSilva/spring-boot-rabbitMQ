package com.ds.spring_rabbit_mq.service;

import com.ds.spring_rabbit_mq.config.RabbitMQConfigProperties;
import com.ds.spring_rabbit_mq.domain.Employee;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RabbitMQSender {
    private final RabbitMQConfigProperties rabbitMQConfigProperties;
    private final AmqpTemplate rabbitTemplate;

    public void send(Employee employee){
        rabbitTemplate.convertAndSend(rabbitMQConfigProperties.getExchange(), rabbitMQConfigProperties.getRoutingKey(), employee);
        System.out.println("Send msg = " + employee);
    }
}
