package com.venkat.ksb.service;

import com.venkat.ksb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeProducer {

    private KafkaTemplate<String, Employee> template;
    private String topic;

    @Autowired
    public EmployeeProducer(@Value("${kafka.topic}") String topic, KafkaTemplate<String, Employee> template){
        this.topic = topic;
        this.template = template;
    }

    public Employee publishMessage(Employee employee){
        long l = System.currentTimeMillis();
        template.send(this.topic, String.valueOf(l), employee);
        log.info("Message is published...");
        return employee;
    }
}
