package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(){
        Employee emp1 = new Employee(200L,"rahul","Java","Developer");
        employeeRepository.save(emp1);
        return "Employee is Added Succefully";
    }

    public Employee getEmployeeById(long empid){
        return employeeRepository.findById(empid).orElse(null);
    }

    public String DeleteEmployee(long empid){
        employeeRepository.deleteById(empid);
        return "Deleted success" ;
    }

    public Employee UpdateByID(long empid){
        Employee emp = employeeRepository.findById(empid)
                .orElseThrow(() ->new RuntimeException("Employee Not found"));
        emp.setEmp_name("prakash");
        return employeeRepository.save(emp);
    }

}
