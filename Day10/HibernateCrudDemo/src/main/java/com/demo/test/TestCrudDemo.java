package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.model.MyUser;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

public class TestCrudDemo {

	public static void main(String[] args) {
		int choice=0;
		Scanner sc=new Scanner(System.in);
		UserService uservice=new UserServiceImpl();
		do {
			System.out.println("1. Add new USer\n2. Display all user\n 3. display by id");
			System.out.println("4. delete by id\n5. update by id\n 6. sort by id\n 7. exit");
			System.out.println("Choice : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				uservice.addnewUser();
				break;
			case 2:
				List<MyUser> ulist=uservice.getAllUsers();
				ulist.forEach(System.out::println);
				break;
			case 3:
				System.out.println("enetr user id to serach");
				int uid=sc.nextInt();
				MyUser u=uservice.getById(uid);
				if(u!=null) {
					System.out.println(u);
				}else {
					System.out.println("not found");
				}
				break;
			case 4:
				System.out.println("enetr user id to serach");
				uid=sc.nextInt();
				boolean status=uservice.removeById(uid);
				if(status) {
					System.out.println("deleted successfully");
				}
				else {
					System.out.println("not found");
				}
				break;
			case 5:
				System.out.println("enetr user id to update");
				uid=sc.nextInt();
				System.out.println("enetr user name to update");
				String unm=sc.next();
				System.out.println("enetr street");
				String street=sc.next();
				status=uservice.modifyById(uid,unm,street);
				if(status) {
					System.out.println("modified successfully");
				}
				else {
					System.out.println("not found");
				}
				break;
				
			case 6:
				 ulist=uservice.sortById();
				 ulist.forEach(System.out::println);
				break;
			case 7:
				uservice.closeMySessionFactory();
				System.out.println("Thank you for visiting......");
				break;
			default:
				System.out.println("wrong choice");
				
			}
			
		}while(choice!=7);
	}

}
