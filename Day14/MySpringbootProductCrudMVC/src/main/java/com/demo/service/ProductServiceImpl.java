package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	 private ProductDao pdao;

	public List<Product> getAllProducts() {
		return pdao.findAll();
	}

	@Override
	public void addnewProduct(Product p) {
		pdao.save(p);
		
	}

	@Override
	public Product getById(int pid) {
		 Optional<Product> op=pdao.findById(pid);
		 if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
	}

	@Override
	public void updateById(Product product) {
		Optional<Product> op=pdao.findById(product.getPid());
		if(op.isPresent()) {
			Product p=op.get();
			p.setPname(product.getPname());
			p.setQty(product.getQty());
			p.setPrice(product.getPrice());
			pdao.save(p);
			
		}
		
	}

	@Override
	public void deleteById(int id) {
		pdao.deleteById(id);
		
	}

	@Override
	public List<Product> getByPrice(int lpr, int hpr) {
		List<Product> plist=pdao.findbyPrice(lpr,hpr);
		System.out.println(plist);
		return plist;
	}

}
