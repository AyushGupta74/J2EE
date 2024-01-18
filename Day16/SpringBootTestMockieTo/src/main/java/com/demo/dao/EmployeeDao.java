package com.demo.dao;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.beans.Employee;

@Component
public class EmployeeDao{ //extends JpaRepository<Employee,Integer>{

	public List<Employee> findAll(){
	     return new ArrayList<>();
    };

	public void saveEmp(Employee emp) {
		System.out.println("in save method");
	}

	public Employee findById(int id) {
		return new Employee();
		
	}

}
