package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
  private ProductDao pdao;

public ProductServiceImpl() {
	pdao=new ProductDaoImpl();
}

@Override
public List<Product> displayAll() {
	return pdao.findAll();
}

@Override
public void addnewProduct() {
	Scanner sc=new Scanner(System.in);
	System.out.println("enetr pid");
	int pid=sc.nextInt();
	System.out.println("enetr Name");
	String pnm=sc.next();
	System.out.println("enetr qty");
	int qty=sc.nextInt();
	System.out.println("enetr price");
	double price=sc.nextDouble();
	Product p=new Product(pid,pnm,qty,price);
	pdao.save(p);
	
}

@Override
public Product getById(int id) {
	return pdao.findById(id);
}

@Override
public boolean deleteById(int id) {
	return pdao.removeById(id);
}

@Override
public boolean modifyById(int id, String pnm, int qty, double price) {
	return pdao.updateById(id,pnm,qty,price);
}

@Override
public List<Product> displaySorted() {
	return pdao.findSorted();
}

@Override
public void closeMyconnection() {
	pdao.closeConnection();
	
}
  
}
