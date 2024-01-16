package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> findAllproducts();

	void save(Product p);

	Product findById(int pid);

	void modifyProduct(Product product);

	void removeById(int id);

}
