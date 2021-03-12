package com.ds.rabbitreceiver.component;

import com.ds.rabbitreceiver.domain.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

    @RabbitListener(queues = "ds.queue")
    public void listen(Employee employee){
        System.out.println("Tenho aqui a mensagem da queue " + employee);
    }
}
