package com.venkat.employee.service;

import com.venkat.employee.dto.EmployeeDto;
import com.venkat.employee.exception.EmployeeNotFoundException;
import com.venkat.employee.mapper.EmployeeMapper;
import com.venkat.employee.model.Employee;
import com.venkat.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmp(employeeDto);
        Employee savedEmp = employeeRepository.save(employee);
        employeeDto.setId(savedEmp.getId());
        return employeeDto;
    }

    public EmployeeDto findById(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return EmployeeMapper.mapToEmpDto(employee);
    }

    public EmployeeDto findByEmail(String email) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findByEmail(email);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee not found for " + email);
        }
        return EmployeeMapper.mapToEmpDto(employee);
    }

    public List<EmployeeDto> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return EmployeeMapper.mapToEmpDto(employees);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteById(String email) {
        Integer id = employeeRepository.findByEmail(email).getId();
        employeeRepository.deleteById(id);
    }


}
