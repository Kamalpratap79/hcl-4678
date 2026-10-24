package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpRepoImp implements EmployeeRepo {
    List<Employee> emplist = new ArrayList<>();

    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employee added succesfully";
    }

    @Override
    public String addEmpBulk(List<Employee> ls) {
        emplist.addAll(ls);
        return "Employee added in bulk";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long empid) {
        return emplist.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);
    }

    @Override
    public String deleteById(long empid) {
        boolean status = false;
        if(getEmpById(empid)!=null){
            status = emplist.removeIf(e->e.getEmp_id()==empid);
        }
        if(status){
            return "Employee deleted succesfully";
        }
        return "Employee is not registered with id"+ empid;
    }

    @Override
    public String updateById(long empid) {
        Employee existingEmp = getEmpById(empid);
        if(existingEmp != null){
            existingEmp.setEmail("kush@gmail.com");
            return "Empoyee Updated Successfully";
        }
        return "Employee not found";
    }
}
