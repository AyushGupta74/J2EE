package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao empDao;
	
	public List<Employee> getEmployeeList(){
		System.out.println("GetEmployee List called");
		return empDao.findAll();
	
	}
	public Employee getById(int id){
		System.out.println("GetById employeeService called");
		return empDao.findById(id);
	
	}
	
	public void addEmp(Employee emp) {
		empDao.saveEmp(emp);
	}

}
