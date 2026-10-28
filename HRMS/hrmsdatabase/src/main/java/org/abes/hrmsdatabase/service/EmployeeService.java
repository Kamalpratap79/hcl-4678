package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean isLoggedIn(long empid, String password) {
        return employeeRepository.existsByPasswordAndEmpid(password,empid);
    }

    public String createNewEmployee(Employee emp1){
        employeeRepository.save(emp1);
        return "Employee is Added Succefully";
    }

    public Employee getEmployeeById(long empid){
        return employeeRepository.findById(empid).orElse(null);
    }

//    public String verifcation(Employee employee){
//        if(employeeRepository.existByEmail(employee.getEmail())){
//
//        }
//    }

    public String DeleteEmployee(long empid){
        employeeRepository.deleteById(empid);
        return "Deleted success" ;
    }

    public Employee UpdateByID(long empid){
        Employee emp = employeeRepository.findById(empid)
                .orElseThrow(() ->new RuntimeException("Employee Not found"));
        emp.setName("prakash");
        return employeeRepository.save(emp);
    }

}
