package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class TestProductCrudDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService pservice=new ProductServiceImpl();
		int choice=0;
		do {
		System.out.println("1. add new product\n2. Delete product\n3. modify product");
		System.out.println("4. display all\n5. display by id\n6. display in sorted order of price\n 7. exit");
		System.out.println("Choice : ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			pservice.addnewProduct();
			break;
		case 2:
			System.out.println("enetr pid");
			int id=sc.nextInt();
			boolean status=pservice.deleteById(id);
			if(status) {
				System.out.println("deleted successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 3:
			System.out.println("enetr pid");
			id=sc.nextInt();
			System.out.println("enetr pname");
			String pnm=sc.next();
			System.out.println("enetr qty");
			int qty=sc.nextInt();
			System.out.println("enetr price");
			double price=sc.nextDouble();
			status=pservice.modifyById(id,pnm,qty,price);
			if(status) {
				System.out.println("modified successfully");
			}
			else {
				System.out.println("not found");
			}
			break;
		case 4:
			List<Product> plist=pservice.displayAll();
			plist.forEach(System.out::println);
			break;
		case 5:
			System.out.println("enetr pid");
			id=sc.nextInt();
			Product p=pservice.getById(id);
			if(p!=null) {
				System.out.println(p);
			}
			else {
				System.out.println("not found");
			}
			break;
		case 6:
			plist=pservice.displaySorted();
			plist.forEach(System.out::println);
			break;
		case 7:
			pservice.closeMyconnection();
			sc.close();
			System.out.println("Thank you for visiting....");
			break;
		default:
			break;
			
		}
		}while(choice!=7);
		

	}

}
