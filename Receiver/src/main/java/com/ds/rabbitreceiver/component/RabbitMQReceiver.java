package com.ds.rabbitreceiver.component;

import com.ds.rabbitreceiver.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQReceiver.class);

    @RabbitListener(queues = "ds.queue")
    public void listen(Employee employee){
        LOGGER.info("app was started");
        LOGGER.info(employee.toString());
        System.out.println("Tenho aqui a mensagem da queue " + employee);
    }
}
