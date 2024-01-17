package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Product;
import com.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService pservice;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getallproducts(){
		List<Product> plist=pservice.getAllProducts();
		return ResponseEntity.ok(plist);
		
	}
	
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getById(@PathVariable int pid){
		Product p=pservice.getById(pid);
		if (p!=null)
			return ResponseEntity.ok(p);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("products/{pid}")
	public ResponseEntity<String> insertProduct(@RequestBody Product p){
		pservice.addnewProduct(p);
		return ResponseEntity.ok("data added successfully");
		
	}
	@PutMapping("products/{pid}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p){
		pservice.updateById(p);
		return ResponseEntity.ok("data updated successfully");
		
	}
	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> removeById(@PathVariable int pid){
		pservice.deleteById(pid);
		return ResponseEntity.ok("data deleted successfully");
		
	}
	

}
