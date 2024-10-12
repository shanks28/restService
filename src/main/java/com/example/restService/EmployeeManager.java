package com.example.restService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service// business logic here
public class EmployeeManager {
    @Autowired
    Employees emps;

    @PostConstruct
    public void createEmployees(){
        List<Employee> list1=new ArrayList<>();
        Employee obj1=new Employee(12,"John","DOE","doe@gmail.com","Manager");
        list1.add(obj1);
        for(int i=0;i<3;i++){
            Integer id=obj1.getEmployeeID()+i;
            Employee obj=new Employee(id,"John","DOE","doe@gmail.com","Manager");
            list1.add(obj);
        }
        emps.setEmployees(list1);
    }
    public List<Employee> getEmployees(){
        return emps.getEmployees();
    }

    public void addEmployee(Employee employee){
        emps.addEmployee(employee);
    }
    public Employee findByID(Integer id){
        List<Employee> employees=emps.getEmployees();
        for(Employee emp:employees){
            if (emp.getEmployeeID().equals(id)){
                return emp;
            }
        }
        return new Employee();
    }
}
