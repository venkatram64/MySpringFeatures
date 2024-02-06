package com.venkat.springJdbc.service;

import com.venkat.springJdbc.model.Employee;
import com.venkat.springJdbc.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //constructor injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee update(Employee employee){
        return employeeRepository.save(employee);
    }

    public String delete(Integer id){
        employeeRepository.deleteById(id);
        return "deleted the record";
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
}
