package com.venkat.multi.springMultiConfig.controller;

import com.venkat.multi.springMultiConfig.model.Employee;
import com.venkat.multi.springMultiConfig.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
