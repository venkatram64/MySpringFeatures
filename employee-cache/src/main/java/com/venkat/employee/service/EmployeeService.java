package com.venkat.employee.service;

import com.venkat.employee.dto.EmployeeDto;
import com.venkat.employee.exception.EmployeeNotFoundException;
import com.venkat.employee.mapper.EmployeeMapper;
import com.venkat.employee.model.Employee;
import com.venkat.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto save(EmployeeDto employeeDto) {
        return getEmployeeDto(employeeDto);
    }

    private EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmp(employeeDto);
        Employee savedEmp = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmpDto(savedEmp);
    }

    @CachePut(value="employees", key="#employeeDto.email")
    public EmployeeDto update(EmployeeDto employeeDto) {
        return getEmployeeDto(employeeDto);
    }

    public EmployeeDto findById(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return EmployeeMapper.mapToEmpDto(employee);
    }

    @Cacheable(value="employees", key="#email")
    public EmployeeDto findByEmail(String email) throws EmployeeNotFoundException {
       log.info("Fetching data from DB for " + email);
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

    @CacheEvict(value="employees", key="#email")
    public void deleteByEmail(String email) {
        Integer id = employeeRepository.findByEmail(email).getId();
        employeeRepository.deleteById(id);
    }


}
