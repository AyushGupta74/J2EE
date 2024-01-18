package com.demo.beans;

public class Employee {
	private int empid;
	private String name;
	private String email;
	
	public Employee() {
		super();
	}

	public Employee(int empid, String name, String email) {
		super();
		this.empid = empid;
		this.name = name;
		this.email = email;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", email=" + email + "]";
	}
	

}
