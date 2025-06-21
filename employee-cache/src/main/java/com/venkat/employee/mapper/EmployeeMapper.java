package com.venkat.employee.mapper;

import com.venkat.employee.dto.EmployeeDto;
import com.venkat.employee.model.Employee;

import java.util.List;

public class EmployeeMapper {

    public static EmployeeDto mapToEmpDto(Employee employee){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .designation(employee.getDesignation())
                .employeeNo(employee.getEmployeeNo())
                .build();
        return employeeDto;
    }

    public static List<EmployeeDto> mapToEmpDto(List<Employee> employees){
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(EmployeeMapper::mapToEmpDto)
                .toList();
        return employeeDtos;
    }

    public static Employee mapToEmp(EmployeeDto employeeDto){
        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .designation(employeeDto.getDesignation())
                .employeeNo(employeeDto.getEmployeeNo())
                .build();
        return employee;
    }
}
