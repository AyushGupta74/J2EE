package com.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
//@Qualifier("e")
public class Employee {
	@Value("10")
   private int empid;
	@Value("Revati")
   private String ename;
public Employee() {
	super();
	System.out.println("in default constructor");
}
public Employee(int empid, String ename) {
	super();
	this.empid = empid;
	this.ename = ename;
	System.out.println("in parametrised constructor");
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
	System.out.println("in setEmpid");
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
	System.out.println("in setEname");
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", ename=" + ename + "]";
}
   
   
}
