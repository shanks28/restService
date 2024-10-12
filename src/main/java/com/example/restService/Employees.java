package com.example.restService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class Employees {
    private List<Employee> employees;

    public Employees(){}

    //getter method
    public List<Employee> getEmployees() {
        return this.employees;
    }
    //setter method
    public void setEmployees(List<Employee> list1){
        this.employees=list1;
    }
    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}
