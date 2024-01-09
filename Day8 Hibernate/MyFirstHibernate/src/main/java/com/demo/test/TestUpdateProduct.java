package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestUpdateProduct {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Product p1=session.get(Product.class,1); //persistent
		session.close();
		//now product is in dettached state
		p1.setPname("shelf");
		
		//reattaching session
		Session session1=sf.openSession();
		Product p2=session1.get(Product.class,1); //persistent
		System.out.println("before commit "+p2);
		Transaction tr2=session1.beginTransaction();
		//throw an exception NonUniqueObjectException
		//session1.update(p1);
		//session1.saveOrUpdate(p1);
		session1.merge(p1);
		tr2.commit();
		session1.close();
		sf.close();
		
		
		
		

	}

}
