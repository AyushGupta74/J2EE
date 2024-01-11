package com.demo.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="NonPeri12")
public class NonPerishableProduct extends Product{
	private String category;

	public NonPerishableProduct() {
		super();
	}

	public NonPerishableProduct(int pid, String pname, Date mfgdate,String category) {
		super(pid,pname,mfgdate);
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NonPerishableProduct [category=" + category + "]";
	}
	
	

}
