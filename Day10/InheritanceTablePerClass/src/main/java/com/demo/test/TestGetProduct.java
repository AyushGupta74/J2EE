package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.PerishableProduct;

public class TestGetProduct {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		PerishableProduct p=session.get(PerishableProduct.class, 12);
		tr.commit();
		session.close();
		sf.close();
		System.out.println(p);

	}

}
