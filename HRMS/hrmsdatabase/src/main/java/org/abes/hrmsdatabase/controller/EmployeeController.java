package org.abes.hrmsdatabase.controller;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("v1/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg(){
        return "<h2> Welcome to SpringBOot APP development</h2>";
    }

    @PostMapping("/addemp")
    public String addNewEmployee(@RequestBody Employee emp){
        return employeeService.createNewEmployee(emp);
    }


    @PostMapping("/login")
    public String login(@RequestParam("empid") long empid,@RequestParam("password") String password){
        if(employeeService.isLoggedIn(empid,password)){
            return "Employee is logged in";
        }else{
            return "Employee Not found";
        }

    }

    @GetMapping("findbyid/{empid}")
    public Employee getEmpById(@PathVariable long empid){
        return employeeService.getEmployeeById(empid);
    }

    @DeleteMapping("deletebyId/{empid}")
    public String deleteById(@PathVariable long empid){
        return employeeService.DeleteEmployee(empid);
    }

    @PutMapping("updatebyid{empid}")
    public Employee updateById(@PathVariable long empid){
        return employeeService.UpdateByID(empid);
    }
}
