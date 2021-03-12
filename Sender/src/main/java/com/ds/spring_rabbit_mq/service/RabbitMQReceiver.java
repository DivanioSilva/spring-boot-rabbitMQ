package com.ds.spring_rabbit_mq.service;

import com.ds.spring_rabbit_mq.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

    //@RabbitListener(queues = "ds.queue")
    public void listen1(Employee employee){
        System.out.println("Tenho aqui a mensagem da queue 1 " + employee);
    }
}
