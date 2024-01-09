package com.demo.service;

import java.util.List;

import com.demo.dao.EmpDao;
import com.demo.dao.EmpDaoImpl;
import com.demo.model.Employee;

public class EmpServiceImpl implements EmpService{
	private EmpDao edao;

	public EmpServiceImpl() {
		super();
		this.edao = new EmpDaoImpl();
	}

	@Override
	public List<Employee> findAllEmployees() {
		return edao.getAllEmployees();
	}

	@Override
	public void addnewemp(Employee e) {
		edao.insertnewEmp(e);
		
	}

	@Override
	public Employee getById(int empid) {
		return edao.findById(empid);
	}

	@Override
	public void modifyemp(Employee e) {
		edao.updateById(e);
		
	}

	@Override
	public void deleteById(int empid) {
		edao.removeById(empid);
		
	}
	

}
