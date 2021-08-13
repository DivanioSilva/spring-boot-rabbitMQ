package com.ds.spring_rabbit_mq.controller;

import com.ds.spring_rabbit_mq.config.RabbitMQRoutingKey;
import com.ds.spring_rabbit_mq.config.Records;
import com.ds.spring_rabbit_mq.config.RecordsBuilder;
import com.ds.spring_rabbit_mq.domain.Employee;
import com.ds.spring_rabbit_mq.domain.EmployeeBuilder;
import com.ds.spring_rabbit_mq.service.RabbitMQSender;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/ds-rabbitmq/")
public class RabbitMQController {
    private final RabbitMQSender rabbitMQSender;

    @PostMapping(value = "producer")
    public String producer(@RequestParam("name") String name, @RequestParam("qtd") int qtd){
        for (int i = 0; i < qtd; i++) {
            Employee emp = new EmployeeBuilder().setName(name).setId(String.valueOf(i)).build();
            Records records =
                    new RecordsBuilder<Employee>()
                            .setContent(emp)
                            .setRoutingKey(RabbitMQRoutingKey.EMPLOYEE.getValue()).createRecords();
            rabbitMQSender.send(records);
        }
        return "Message sent to the RabbitMQ successfully";
    }
}
