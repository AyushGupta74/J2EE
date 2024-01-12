package com.demo.model;

public class MyUSer {
	private int uid;
	private String uname;
	private Address addr;
	//private Course c;
	//private Skill s;
	public MyUSer() {
		super();
	}
	public MyUSer(int uid, String uname, Address addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.addr = addr;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "MyUSer [uid=" + uid + ", uname=" + uname + ", addr=" + addr + "]";
	}
	

}
