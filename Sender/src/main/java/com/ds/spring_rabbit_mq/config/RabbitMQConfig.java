package com.ds.spring_rabbit_mq.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class RabbitMQConfig {
    private final RabbitMQConfigProperties rabbitMQConfigProperties;

    @Bean
    public Queue saveFileQueue(){
        return new Queue(RabbitMQQueues.SAVE_FILE.getValue(), true);
    }

    @Bean
    public Queue deleteFileQueue(){
        return new Queue(RabbitMQQueues.DELETE_FILE.getValue(), true);
    }

    @Bean
    public Queue sendEmailQueue(){
        return new Queue(RabbitMQQueues.SEND_EMAIL.getValue(), true);
    }

    @Bean
    public Queue sendSMSQueue(){
        return new Queue(RabbitMQQueues.SEND_SMS.getValue(), true);
    }

    @Bean
    public Binding saveFileBinding(Queue saveFileQueue, DirectExchange directExchange){
        return BindingBuilder.bind(saveFileQueue).to(directExchange).with(RabbitMQRoutingKey.SAVE_FILE.getValue());
    }

    @Bean
    public Queue employeeQueue(){
        return new Queue(RabbitMQQueues.EMPLOYEE.getValue(), true);
    }

    @Bean
    public Binding employeeBinding(Queue employeeQueue, DirectExchange directExchange){
        return BindingBuilder.bind(employeeQueue).to(directExchange).with(RabbitMQRoutingKey.EMPLOYEE.getValue());
    }

    @Bean
    public Binding deleteFileBinding(Queue deleteFileQueue, DirectExchange directExchange){
        return BindingBuilder.bind(deleteFileQueue).to(directExchange).with(RabbitMQRoutingKey.DELETE_FILE.getValue());
    }

    @Bean
    public Binding sendEmailBinding(Queue sendEmailQueue, DirectExchange directExchange){
        return BindingBuilder.bind(sendEmailQueue).to(directExchange).with(RabbitMQRoutingKey.SEND_EMAIL.getValue());
    }

    @Bean
    public Binding sendSMSBinding(Queue sendSMSQueue, DirectExchange directExchange){
        return BindingBuilder.bind(sendSMSQueue).to(directExchange).with(RabbitMQRoutingKey.SEND_SMS.getValue());
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(rabbitMQConfigProperties.getExchange());
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate rabbitTemplateTest(ConnectionFactory connectionFactory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
