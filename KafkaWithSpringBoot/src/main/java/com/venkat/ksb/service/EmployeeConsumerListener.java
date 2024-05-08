package com.venkat.ksb.service;

import com.venkat.ksb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeConsumerListener {

    /*@KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload Employee employee){
        log.info("employee name " + employee.getFirstName());
        log.info("Message is consumed " + employee.toString());
    }*/
}
