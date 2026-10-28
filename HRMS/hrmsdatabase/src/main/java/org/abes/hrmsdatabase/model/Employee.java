package org.abes.hrmsdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private long empid;

    private String name;
    private String email;
    private String designation;
    private String techStack;
    private String password;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(long empid, String name, String email,
                    String designation, String techStack,
                    String password) {
        this.empid = empid;
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.techStack = techStack;
        this.password = password;
    }

    public long getEmpid() {
        return empid;
    }

    public void setEmpid(long empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
