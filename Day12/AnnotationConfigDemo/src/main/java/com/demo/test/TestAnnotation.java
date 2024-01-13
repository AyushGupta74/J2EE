package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

public class TestAnnotation {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		Employee e1=(Employee) ctx.getBean("employee");
		System.out.println(e1);
		EmployeeService eservice=(EmployeeService) ctx.getBean("employeeServiceImpl");
		
	}

}
