package com.demo.model;

public class MyUser {
	private String user_name;
	private String password;
	private String roles;
	public MyUser() {
		super();
	}
	public MyUser(String user_name, String password, String roles) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.roles = roles;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "MyUser [user_name=" + user_name + ", password=" + password + ", roles=" + roles + "]";
	}
	

}
