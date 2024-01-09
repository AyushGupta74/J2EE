package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmpService {

	List<Employee> findAllEmployees();

	void addnewemp(Employee e);

	Employee getById(int empid);

	void modifyemp(Employee e);

	void deleteById(int empid);

}
