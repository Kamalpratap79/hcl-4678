package org.abesproject.hclhrms.controller;

import org.abesproject.hclhrms.Service.EmployeeServiceImp;
import org.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/")
    public String welcomeMsg(){
        return "Welcome to ABES HRMS";
    }

    @GetMapping("/addemp")
    public String addnewEmployee(){
        return employeeServiceImp.addEmp();
    }

    @GetMapping("/getemp")
    public List<Employee> getEmp(){
        return employeeServiceImp.getEmp();
    }

    @GetMapping("/getempId")
    public Employee getEmpById(){
        return employeeServiceImp.getEmpById();
    }

    @GetMapping("addinbulk")
    public String addEmpInBulk(){
        return employeeServiceImp.addEmpBulk();
    }

    @DeleteMapping("/deleteById")
    public String deleteById(){
        return employeeServiceImp.deleteById();
    }

    @PutMapping("/updateById")
    public String updateById(){
        return employeeServiceImp.updateById();
    }
}
