package com.venkat.employee.controller;


import com.venkat.employee.dto.EmployeeDto;
import com.venkat.employee.exception.EmployeeNotFoundException;
import com.venkat.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>>  getAllEmployees() {
        return ResponseEntity.ok(this.employeeService.findAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<EmployeeDto>  getEmployee(@PathVariable String email) throws EmployeeNotFoundException {
        EmployeeDto emp = this.employeeService.findByEmail(email);
        return ResponseEntity.ok(emp);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto>  createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        return ResponseEntity.ok(this.employeeService.save(employeeDto));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto>  updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(this.employeeService.save(employeeDto));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void>  deleteEmployee(String email) throws EmployeeNotFoundException {
        this.employeeService.findByEmail(email);
        return ResponseEntity.ok().build();
    }


}
