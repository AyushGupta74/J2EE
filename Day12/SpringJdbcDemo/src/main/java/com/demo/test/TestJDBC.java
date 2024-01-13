package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Product;
import com.demo.service.ProductService;

public class TestJDBC {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService pservice=(ProductService)ctx.getBean("productServiceImpl");
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. add new product\n 2. delete product\n 3. modify product");
			System.out.println("4. display all\n5.display by id\n6. display by qty\n7.exit");
			System.out.println("choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				int n=pservice.addnewProduct();
				if(n>0) {
					System.out.println("added suucessfully");
				}
				break;
			case 2:
				System.out.println("enetr id");
				int pid=sc.nextInt();
				n=pservice.deleteById(pid);
				if(n>0) {
					System.out.println("deleted suucessfully");
				}else {
					System.out.println("not found");
				}
				break;
			case 3:
				System.out.println("enetr pid");
				pid=sc.nextInt();
				System.out.println("enetr qty");
				int qty=sc.nextInt();
				System.out.println("enetr price");
				double pr=sc.nextDouble();
				n=pservice.modifyById(pid,qty,pr);
				if(n>0) {
					System.out.println("updated suucessfully");
				}else {
					System.out.println("not found");
				}
				break;
			case 4:
				List<Product> plist=pservice.getAll();
				plist.forEach(System.out::println);
				break;
			case 5:
				System.out.println("enetr id");
				pid=sc.nextInt();
				Product p=pservice.getById(pid);
				if (p!=null) {
					System.out.println(p);
				}
				else {
					System.out.println("not found");
				}
				break;
			case 6:
				System.out.println("enetr qty");
				qty=sc.nextInt();
				plist=pservice.getByQty(qty);
				plist.forEach(System.out::println);
				break;
			case 7:
				System.out.println("Thank you for visiting.....");
				break;
			default:
				System.out.println("wrong choice");
				
			}
		}while(choice!=7);

	}

}
