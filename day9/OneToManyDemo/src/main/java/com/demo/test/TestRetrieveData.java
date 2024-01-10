package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Department;
import com.demo.model.Employee;

public class TestRetrieveData {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Department d1=session.get(Department.class, 10);
		Employee e1=session.get(Employee.class,14 );
		System.out.println(d1); 
		System.out.println(d1.getEset());
		System.out.println(e1);
		tr.commit();
		

	}

}
