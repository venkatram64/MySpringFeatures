package com.venkat.consumer.controller;

import com.venkat.consumer.dto.EmployeeDto;
import com.venkat.consumer.model.Employee;
import com.venkat.consumer.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        return ResponseEntity.ok().body(this.employeeService.findAllEmployees());
    }
}
