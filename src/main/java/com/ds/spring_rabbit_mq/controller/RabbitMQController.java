package com.ds.spring_rabbit_mq.controller;

import com.ds.spring_rabbit_mq.domain.Employee;
import com.ds.spring_rabbit_mq.domain.EmployeeBuilder;
import com.ds.spring_rabbit_mq.service.RabbitMQSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/ds-rabbitmq/")
public class RabbitMQController {
    private final RabbitMQSender rabbitMQSender;

    @GetMapping(value = "producer")
    public String producer(@RequestParam("name") String name, @RequestParam("qtd") int qtd){
        for (int i = 0; i < qtd; i++) {
            Employee emp = new EmployeeBuilder().setName(name).setId(String.valueOf(i)).build();

            rabbitMQSender.send(emp);
        }
        return "Message sent to the RabbitMQ successfully";
    }
}
