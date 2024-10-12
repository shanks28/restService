package com.example.restService;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Employee {
    private Integer employeeID;
    private String first_name;
    private String last_name;
    private String email;
    private String title;
    public Employee(){}
    public Employee(Integer id,String first_name,String last_name,
                    String email,String title) {
        this.employeeID = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.title = title;
    }
    public Integer getEmployeeID() {
        return this.employeeID;
    }

    public String getEmail() {
        return this.email;
    }
    public String getTitle(){
        return this.title;
    }
    public String getFirst_name(){
        return this.first_name;

    }
    public String getLast_name(){
        return this.last_name;
    }
}
