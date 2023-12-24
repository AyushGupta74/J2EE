package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> findAll();

	boolean save(Product p);

	Product findById(int pid);

	boolean updateProductById(Product p);

	boolean deleteProduct(int pid);

}
