package com.example.restService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeManager employeeManager;

    @GetMapping
    public Map<String, List<Employee>> getAllEmployees() {
        Map<String, List<Employee>> response = new HashMap<>();
        response.put("Employees",employeeManager.getEmployees());
        return response;

    }

    @PostMapping
    public String addEmployee(@RequestBody requestBody.AddEmployeeRequest obj) {
        try {
            Employee obj1 = new Employee(obj.getEmployee_id(), obj.getFirst_name(), obj.getLast_name(), obj.getEmail(), obj.getTitle());
            employeeManager.addEmployee(obj1);
            return "Successfully added an object";
        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
    }
    @GetMapping("/{id}")
    public Employee findByID(@PathVariable("id") Integer id){
        return employeeManager.findByID(id);
    }
}
