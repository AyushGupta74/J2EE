package com.demo.beans;

public class Product {
	private int pid;
	private String pnm;
	private int qty;
	private double price;
	public Product() {
		super();
	}
	public Product(int pid, String pnm, int qty, double price) {
		super();
		this.pid = pid;
		this.pnm = pnm;
		this.qty = qty;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPnm() {
		return pnm;
	}
	public void setPnm(String pnm) {
		this.pnm = pnm;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pnm=" + pnm + ", qty=" + qty + ", price=" + price + "]";
	}
	

}
