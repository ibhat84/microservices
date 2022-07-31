package com.example.departmentservice.service;


import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department save(Department department) {

        return departmentRepository.save(department);

    }

    public Department getDepartment(Long deptId) {
        return departmentRepository.findByDepartmentId(deptId);

    }
}
