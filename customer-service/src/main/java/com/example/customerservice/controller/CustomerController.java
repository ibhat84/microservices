package com.example.customerservice.controller;


import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @PostMapping("/")
    public Customer addCustomer(@Valid @RequestBody String customerAsJson) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(customerAsJson, Customer.class);
        System.out.println(customer);

        return customerService.save(customer);

    }

    @GetMapping("/")
    public String sayHi(){
    return "Hi- This is Customer Service";
    }

}
