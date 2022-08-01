package com.example.studentservice.service;

import com.example.studentservice.VO.Department;
import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.repository.StudentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Student saveStudent(Student student) {
        log.info("Inside StudentService - saveStudent");
        return studentRepository.save(student);
    }

    //@CircuitBreaker(name = "serviceA", fallbackMethod = "getStudentWithDeptFallback")
    //@Retry(name = SERVICE_A)
   // @RateLimiter(name = SERVICE_A)
    public ResponseTemplateVO getStudentWithDept(Long studentId) {

        log.info("Inside StudentService - getStudentWithDept");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Student student = studentRepository.findByStudentId(studentId);

        Department dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" +student.getDeptId(), Department.class);
        vo.setStudent(student);
        vo.setDept(dept);

        return vo;
    }


    @CircuitBreaker(name = "serviceA", fallbackMethod = "testCircuitBreakerFallback")
    public String testCircuitBreaker() {

        return restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/", String.class);

    }

    public String testCircuitBreakerFallback(Exception e) {

        return "URL Down - Try Later";

    }

}

