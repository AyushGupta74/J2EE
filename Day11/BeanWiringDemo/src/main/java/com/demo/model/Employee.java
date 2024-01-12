package com.demo.model;

public class Employee extends Person{
   private String dept;
   private String desg;
public Employee() {
	super();
}
public Employee(int pid, String pname,String dept, String desg) {
	super(pid,pname);
	this.dept = dept;
	this.desg = desg;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getDesg() {
	return desg;
}
public void setDesg(String desg) {
	this.desg = desg;
}
@Override
public String toString() {
	return "Employee [dept=" + dept + ", desg=" + desg + "]";
}
   
}
