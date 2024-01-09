package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmpDao {

	List<Employee> getAllEmployees();

	void insertnewEmp(Employee e);

	Employee findById(int empid);

	void updateById(Employee e);

	void removeById(int empid);

}
