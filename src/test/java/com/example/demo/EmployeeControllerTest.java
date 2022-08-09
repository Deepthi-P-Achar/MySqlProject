


package com.example.demo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.web.controller.EmployeeController;
import com.example.web.dao.EmployeeRepository;
import com.example.web.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest{
	
	private MockMvc mockMvc;
	
	@InjectMocks
    EmployeeController employeeController;
     
    @Mock
    EmployeeRepository employeeDAO;
  
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }
   
     
    @Test
    public void testfindAllEmployees() 
    {
        // given
        Employee employee1 = new Employee(1, "Lokesh",1500000,"IT",2);
        Employee employee2 = new Employee(2, "Alex", 2000000,"IT", 3);
        
       
 
        //when(employeeDAO.findAll()).thenReturn(Arrays.asList(employee1, employee2));
 
        // when
       // Mockito.when(employeeDAO.findAll()).thenReturn(Arrays.asList(employee1, employee2));  


        Mockito.when(employeeDAO.findAll()).thenReturn(Arrays.asList(employee1, employee2));
        try {
			mockMvc.perform(get("/api/employee")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(2)))
			.andExpect(jsonPath("$[0].name", Matchers.equalTo("Lokesh")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
         
       
    }

}


