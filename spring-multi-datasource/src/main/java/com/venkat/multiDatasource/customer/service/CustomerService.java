package com.venkat.multiDatasource.customer.service;

import com.venkat.multiDatasource.customer.model.Customer;
import com.venkat.multiDatasource.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Integer id){
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public String deleteById(Integer id){
        customerRepository.deleteById(id);
        return "Customer is deleted...";
    }
}
