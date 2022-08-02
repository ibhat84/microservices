package com.example.departmentservice.controller;


import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentClass {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department save(@RequestBody Department department){

        return departmentService.save(department);

    }

    @GetMapping("/{id}")
    public Department getDept(@PathVariable("id") Long deptId ){
        return departmentService.getDepartment(deptId);

    }

    @GetMapping("/all")
    public List<Department> getAllDept(){
        return departmentService.getAllDept();

    }

    @GetMapping("/")
    public String sayHi(){
        return "Hello - This is Department Service";

    }




}
