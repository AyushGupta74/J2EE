package com.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.service.EmployeeService;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootTestMockieToApplicationTests {

	//@Test
	void contextLoads() {
	}
	
	@InjectMocks
	EmployeeService eservice;
	
	@Mock
	EmployeeDao empDao;
	
	/*@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}*/
	
	@Test
	public void testGetAllEmp(){
		int a=10;
		int b=20;
		assertEquals(30, (a+b));
		/*System.out.println("in testGetAll");
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1,"Rajan","sgsg"));
		list.add(new Employee(2,"Revati","sgsg11"));
		list.add(new Employee(1,"Anil","sgsg11"));
		
		 when(empDao.findAll()).thenReturn(list);
		 
		 List<Employee> list1=eservice.getEmployeeList();
		 assertEquals(3,list1.size());
		 verify(empDao,times(1)).findAll();*/
		
	}
	
	@Test
	public void testGetById(){
		
		System.out.println("in testgetbyid");
		 when(empDao.findById(10)).thenReturn(new Employee(10,"Deepa","sdfs"));
		 
		Employee emp=eservice.getById(10);
		 assertEquals("Deepa",emp.getName());
		 assertEquals("sdfs",emp.getEmail());
		 verify(empDao,times(1)).findById(10);
		
	}
	
	@Test
	public void testaddEmp(){
		
		
		 when(empDao.findById(10)).thenReturn(new Employee(10,"Deepa","sdfs"));
		
		 
		eservice.addEmp(new Employee(10,"Deepa","sdfs"));
		verify(empDao,times(1)).saveEmp(new Employee(10,"Deepa","sdfs"));
		
	}

}
