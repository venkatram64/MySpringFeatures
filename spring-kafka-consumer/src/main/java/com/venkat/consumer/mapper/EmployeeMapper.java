package com.venkat.consumer.mapper;

import com.venkat.consumer.dto.EmployeeDto;
import com.venkat.consumer.model.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmpDto(Employee employee){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .designation(employee.getDesignation())
                .employeeNo(employee.getEmployeeNo())
                .build();
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .designation(employeeDto.getDesignation())
                .employeeNo(employeeDto.getEmployeeNo())
                .build();
        return employee;
    }
}
