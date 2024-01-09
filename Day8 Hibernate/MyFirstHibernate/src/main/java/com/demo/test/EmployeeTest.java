package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;
import com.demo.model.MyUser;

public class EmployeeTest {
	public static void main(String[] args) {
		//it is in transient state
		Employee e1=new Employee(14,"Sahil",3456);
		Employee e2=new Employee(15,"Akash",5555);
		Employee e3=new Employee(17,"Tanaya",4545);
		MyUser u1=new MyUser(10,"xxxx");
		MyUser u2=new MyUser(11,"yyyy");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//e1 is in persistent state
		session.save(e1);
		session.save(e2);
		session.save(u1);
		session.save(u2);
		tr.commit();
		session.close();
		Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		//by default it is early fetch
		//Employee emp1=sess1.get(Employee.class, 14);
		//by default it is lazy fetch
		Employee emp1=sess1.load(Employee.class, 14);
		System.out.println("before");
		System.out.println(emp1.getEname());
		System.out.println("after");
		tr1.commit();
		
		
	}

}
