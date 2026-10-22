package org.abesproject.hclhrms.Service;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmpRepoImp empRepoImp;

    public String addEmp(){
        Employee emp1 = new Employee(2000,"teotia","FSD","Java","harsh@gmail.com");
        return empRepoImp.addemp(emp1);
    }

    public List<Employee> getEmp() {
        return empRepoImp.getEmp();
    }

    public Employee getEmpById(){
        return empRepoImp.getEmpById(2000);
    }

    public String addEmpBulk(){
        List<Employee> temp = new ArrayList<>();
        temp.add(new Employee(2000,"teotia","FSD","Java","harsh@gmail.com"));
        temp.add(new Employee(2001,"teo","FSD","Java","harsh@gmail.com"));
        temp.add(new Employee(2002,"tia","FSD","Java","harsh@gmail.com"));
        temp.add(new Employee(2003,"ttia","FSD","Java","harsh@gmail.com"));
        return empRepoImp.addEmpBulk(temp);
    }
}
