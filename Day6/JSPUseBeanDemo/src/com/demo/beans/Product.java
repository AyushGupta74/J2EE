package com.demo.beans;

public class Product {
  private int pid;
  private String pname;
  private int qty;
  private double price;
public Product() {
	super();
	System.out.println("in product constructor");
}
public Product(int pid, String pnm, int qty, double price) {
	super();
	this.pid = pid;
	this.pname = pnm;
	this.qty = qty;
	this.price = price;
}
public int getPid() {
	System.out.println("in product getpid()");
	return pid;
}
public void setPid(int pid) {
	System.out.println("in product setpid()");
	this.pid = pid;
}
public String getPname() {
	System.out.println("in product getpname()");
	return pname;
}
public void setPname(String pnm) {
	System.out.println("in product setpname()");
	this.pname = pnm;
}
public int getQty() {
	System.out.println("in product getQty()");
	return qty;
}
public void setQty(int qty) {
	System.out.println("in product setqty()");
	this.qty = qty;
}
public double getPrice() {
	System.out.println("in product getprice()");
	return price;
}
public void setPrice(double price) {
	System.out.println("in product setprice()");
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pnm=" + pname + ", qty=" + qty + ", price=" + price + "]";
}
  
}
