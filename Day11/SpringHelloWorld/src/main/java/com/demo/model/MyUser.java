package com.demo.model;

public class MyUser {
	private int uid;
	private String uname;
	public MyUser() {
		super();
		System.out.println("in Myuser default constructor");
	}
	public MyUser(int uid, String uname) {
		super();
		System.out.println("in Myuser parametrised constructor");
		this.uid = uid;
		this.uname = uname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in Myuser uid setter method");
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("in Myuser uname setter method");
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}
	

}
