package com.example.apigateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/studentServiceFallBack")
    @CircuitBreaker(name = "breaker", fallbackMethod = "getStudentInfoFallback")
    public String studentServiceFallbackMethod(){
        return "Oops StudentService taking longer than expected.";
    }

    @GetMapping("/deptServiceFallBack")
    public String deptServiceFallbackMethod(){
        return "Oops DeptService taking longer than expected.";
    }

}
