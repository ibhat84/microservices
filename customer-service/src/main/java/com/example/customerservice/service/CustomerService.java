package com.example.customerservice.service;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    @Autowired
    public CustomerRepository customerRepository;


    public Customer save(Customer customer) {

        System.out.println("In Service layer - Save");
        return customerRepository.save(customer);
    }
}
