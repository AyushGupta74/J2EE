package com.demo.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="periprod12")

public class PerishableProduct extends Product{
	private Date expiryDate;

	public PerishableProduct() {
		super();
	}

	public PerishableProduct(int pid, String pname, Date mfgdate,Date expiryDate) {
		super(pid,pname,mfgdate);
		this.expiryDate = expiryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "PerishableProduct [expiryDate=" + expiryDate + "]";
	}
	

}
