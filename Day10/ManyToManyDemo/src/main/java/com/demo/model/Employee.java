package com.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name="emptab11")
public class Employee {
	@Id
	private int empid;
	private String ename;
	@ManyToMany//(fetch=FetchType.EAGER)
	@JoinTable(name="emp_proj11",joinColumns= {@JoinColumn(name="empid")},
	inverseJoinColumns= {@JoinColumn(name="projid")})
	Set<Project> pset;
	public Employee() {
		super();
	}
	
	public Employee(int empid, String ename) {
		super();
		this.empid = empid;
		this.ename = ename;
	}

	public Employee(int empid, String ename, Set<Project> pset) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.pset = pset;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Set<Project> getPset() {
		return pset;
	}
	public void setPset(Set<Project> pset) {
		this.pset = pset;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", pset=" + pset + "]";
	}
	

}
