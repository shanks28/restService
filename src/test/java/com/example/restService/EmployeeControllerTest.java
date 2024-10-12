package com.example.restService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    @MockBean
    EmployeeManager manager; // acts as service layer.
    //the employees class is the data repo layer

    Employee emp1=new Employee(1,"John","Doe","doe@gmail.com","manager");
    Employee emp2=new Employee(2,"John","Doe","doe@gmail.com","manager");
    @Test
    public void getAllEmployeesTest() throws Exception{
        List<Employee> list1=new ArrayList<>(Arrays.asList(emp1,emp2));
        Mockito.when(manager.getEmployees()).thenReturn(list1);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Employees", hasSize(2)));
 //               .andExpect((ResultMatcher) jsonPath("$.Employees[1].first_name", is("John")));
    }
}
