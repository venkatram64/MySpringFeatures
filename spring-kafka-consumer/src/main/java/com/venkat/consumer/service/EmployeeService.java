package com.venkat.consumer.service;

import com.venkat.consumer.dto.EmployeeDto;
import com.venkat.consumer.mapper.EmployeeMapper;
import com.venkat.consumer.model.Employee;
import com.venkat.consumer.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return this.employeeRepository.save(employee);
    }
    public List<EmployeeDto> findAllEmployees(){
        List<EmployeeDto> employeeDtos = this.employeeRepository.findAll()
                .stream()
                .map(emp -> EmployeeMapper.mapToEmpDto(emp))
                .collect(Collectors.toList());
        return employeeDtos;
    }
}
