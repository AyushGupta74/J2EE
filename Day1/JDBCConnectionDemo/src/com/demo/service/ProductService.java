package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> displayAll();

	void addnewProduct();

	Product getById(int id);

	boolean deleteById(int id);

	boolean modifyById(int id, String pnm, int qty, double price);

	List<Product> displaySorted();

	void closeMyconnection();

}
