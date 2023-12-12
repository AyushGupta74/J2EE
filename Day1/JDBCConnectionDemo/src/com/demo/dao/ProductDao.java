package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAll();

	void save(Product p);

	Product findById(int id);

	boolean removeById(int id);

	boolean updateById(int id, String pnm, int qty, double price);

	List<Product> findSorted();

	void closeConnection();

}
