package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {
	
	@InjectMocks
	EmployeeService eservice;
	
	@Mock
	EmployeeDao empDao;
	
	@Test
	public void testGetAllEmp(){
		System.out.println("in testGetAll");
		List<Employee> list=new ArrayList<>();
		list.add(new Employee(1,"Rajan","sgsg"));
		list.add(new Employee(2,"Revati","sgsg11"));
		list.add(new Employee(1,"Anil","sgsg11"));
		
		 when(empDao.findAll()).thenReturn(list);
		 
		 List<Employee> list1=eservice.getEmployeeList();
		 assertEquals(3,list1.size());
		 verify(empDao,times(1)).findAll();
		
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
	
	@Ignore
	@Test
	public void testaddEmp(){
		
		
		 when(empDao.findById(10)).thenReturn(new Employee(10,"Deepa","sdfs"));
		
		 
		eservice.addEmp(new Employee(10,"Deepa","sdfs"));
		verify(empDao,times(1)).saveEmp(new Employee(10,"Deepa","sdfs"));
		
	}
}
