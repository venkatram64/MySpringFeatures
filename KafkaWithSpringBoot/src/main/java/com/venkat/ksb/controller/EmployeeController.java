package com.venkat.ksb.controller;

import com.venkat.ksb.model.Employee;
import com.venkat.ksb.service.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeProducer employeeProducer;

    @PostMapping(value="newEmp",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> save(@RequestBody Employee employee){
        try {
            return ResponseEntity.ok().body(employeeProducer.publishMessage(employee));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
