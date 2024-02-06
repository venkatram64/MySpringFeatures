package com.venkat.multi.springMultiConfig.repository;

import com.venkat.multi.springMultiConfig.model.Employee;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ListCrudRepository<Employee, Integer> {
}
