package com.cg.spring.mvc.service;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.spring.mvc.beans.Employee;
import com.cg.spring.mvc.repository.IEmployeeRep;

@RunWith(MockitoJUnitRunner.class)
public class Servicetests {

	@Autowired
	private EmployeeServiceImpl service;
	
	@Mock
	private IEmployeeRep repo;
	
	@Test
	public void getAllEmpTest() {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ajay");
		emp.setSalary(1000);
		emp.setAge(21);
		emp.setAddress("mancherial");
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		mockito.when(repo.getAllEmp()).thenReturn(list);
		assertThat(service.getAllEmp()).isEqualTo(list);
	}
	@Test
	public void addEmployeeTest() {		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ajay");
		emp.setSalary(1000);
		emp.setAge(21);
		emp.setAddress("mancherial");
		Mockito.when(repo.addEmp(emp)).thenReturn(emp);    
        assertThat(service.addEmp(emp)).isEqualTo(emp);		
	}
	@Test
	public void employeeSearchTest() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ajay");
		emp.setSalary(1000);
		emp.setAge(21);
		emp.setAddress("mancherial");
		Mockito.when(repo.searchById(1)).thenReturn(emp);    
        assertThat(service.searchById(1)).isEqualTo(emp);	
	}
	@Test
	public void deleteEmpTest() {
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Ajay");
		emp.setSalary(1000);
		emp.setAge(21);
		emp.setAddress("mancherial");
		Mockito.when(repo.searchById(1)).thenReturn(emp);    
        Mockito.when(repo.searchById(emp.getId())).thenReturn(false);
 	   assertFalse(repo.searchById(emp.getId()));
		
	}
@Test
public void updateEmpTest() {
	Employee emp = new Employee();
	emp.setId(1);
	emp.setName("Ajay");
	emp.setSalary(1000);
	emp.setAge(21);
	emp.setAddress("mancherial");
	Mockito.when(repo.searchById(1)).thenReturn(emp);
	emp.setAddress("Devapur");
	Mockito.when(repo.addEmp(emp)).thenReturn(emp);
	assertThat(service.update(1, "ajay", 1000, 21, "Devapur")).isEqualTo(emp);
}

}
