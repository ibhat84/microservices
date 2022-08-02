package com.example.departmentservice;

import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {ServiceMockitoTest.class})
@ExtendWith(MockitoExtension.class)
public class ServiceMockitoTest {


    @Mock
    DepartmentRepository deptRepo;

    @InjectMocks
    DepartmentService deptServ;

    @Test
    @Order(1)
    public void test_getDepartment(){

        Long deptId = 1L;
        Department dept = new Department();
        dept.setDepartmentId(deptId);
        dept.setDepartmentName("CS");
        dept.setDepartmentAddress("1111 Lex Ave");
        dept.setDepartmentCode("201");

        when(deptRepo.findByDepartmentId(deptId)).thenReturn(dept);

        Department deptReturned = deptServ.getDepartment(deptId);

        assertEquals(1,deptReturned.getDepartmentId());
        assertEquals("CS",deptReturned.getDepartmentName());
        assertEquals("1111 Lex Ave",deptReturned.getDepartmentAddress());
        assertEquals("201",deptReturned.getDepartmentCode());

    }


    @Test
    @Order(2)
    public void test_getAllDept(){

        Long deptId = 1L;
        List<Department> deptListTest = new ArrayList<Department>();
        Department dp1 = new Department(1L,"CS","1111 Lex Ave","301");
        Department dp2 = new Department(2L,"EE","1134 Phillips Ave","401");

        deptListTest.add(dp1);
        deptListTest.add(dp2);


        when(deptRepo.findAll()).thenReturn(deptListTest);

        List<Department> deptListReturned = deptServ.getAllDept();

       // deptListReturned.stream().forEach(d-> System.out.println(d.getDepartmentId()));

        assertNotNull(deptListReturned);
        assertEquals(2,deptListReturned.size());
        verify(deptRepo,times(1)).findAll();

    }

}
