package com.example.feignclientms.controller;

import com.example.feignclientms.service.DepartmentConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignClientController {

    @Autowired
    private DepartmentConsumer deptConsumer;

    @GetMapping("/dept")
    public String getDepartment(){

        return deptConsumer.sayHi();

    }

}
