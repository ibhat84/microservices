package com.example.feignclientms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface DepartmentConsumer {

    @GetMapping("/department/")
    public String sayHi();

}
