package com.venkat.consumer.service;

import com.venkat.consumer.deser.EmployeeDeserializer;
import com.venkat.consumer.dto.EmployeeDto;
import com.venkat.consumer.mapper.EmployeeMapper;
import com.venkat.consumer.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeConsumerService {

    private final EmployeeService employeeService;

    public EmployeeConsumerService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(@Payload EmployeeDto employeeDto){
        log.info("Message is consuming...");
        log.info("employee name " + employeeDto.getFirstName());
        log.info("Message is consumed " + employeeDto.toString());
        //further processing to save the record in database
        log.info("Message is inserting into database..");
        Employee emp = EmployeeMapper.mapToEmployee(employeeDto);
        this.employeeService.save(emp);
    }
}
