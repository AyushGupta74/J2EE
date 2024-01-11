package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;



public class TestAddProduct {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product p=new Product(1,"xxx",20,100);
		Product p1=new Product(2,"yyy",15,200);
		Product p2=new Product(3,"zzz",40,500);
		Product p3=new Product(4,"pppp",50,600);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p);
		tr.commit();
		session.close();
		sf.close();
		

	}

}
