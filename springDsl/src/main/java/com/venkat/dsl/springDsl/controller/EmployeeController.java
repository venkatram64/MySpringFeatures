package com.venkat.dsl.springDsl.controller;

import com.venkat.dsl.springDsl.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    @GetMapping  //http://localhost:8090/api/emp
    public Employee getEmployee(){
        return new Employee(1,"Venkatram", "venkat@venkat.com", 1234567.0);
    }
}
