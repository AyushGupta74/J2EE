package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	int save(Product p);

	List<Product> findAll();

	Product findById(int pid);

	List<Product> findByQty(int qty);

	int deletById(int pid);

	int updateById(int pid, int qty, double pr);

}
