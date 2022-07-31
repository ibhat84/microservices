package com.example.studentservice.controller;

import com.example.studentservice.VO.ResponseTemplateVO;
import com.example.studentservice.entity.Student;
import com.example.studentservice.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student)
    {
        log.info("Inside Controller - saveStudent");
        return studentService.saveStudent(student);
    }


    @GetMapping("/{id}")
    public ResponseTemplateVO getStudentWithDept(@PathVariable("id") Long studentId)
    {
        log.info("Inside ResponseTemplateVO");
        return studentService.getStudentWithDept(studentId);
    }

    @GetMapping("/")
    public String sayHi()
    {
        return "Hello There!";

    }

}
