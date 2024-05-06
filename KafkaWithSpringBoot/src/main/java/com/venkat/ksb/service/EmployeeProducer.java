package com.venkat.ksb.service;

import com.venkat.ksb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

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
        CompletableFuture<SendResult<String, Employee>> future = template.send(this.topic, String.valueOf(l), employee);
        future.whenComplete((result, ex) ->{
            if(ex == null) {
                log.info("Message {} with partition and offset {} is published", employee,
                        result.getRecordMetadata().partition(), result.getRecordMetadata().offset());
            }else{
                log.error("Failed to publish due to {} ", ex.getMessage());
            }
        });
        log.info("Message is published...");
        return employee;
    }
}
