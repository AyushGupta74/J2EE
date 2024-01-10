package com.demo.test;

import java.util.HashSet;
import java.util.Set;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Department;
import com.demo.model.Employee;

public class TestOneToMany {

	public static void main(String[] args) {
		Employee e1=new Employee(12,"xxx",3456);
		Employee e2=new Employee(13,"yyyy",5555);
		Employee e3=new Employee(14,"zzzzz",5656);
		Employee e4=new Employee(15,"pppp",4444);
		Set<Employee> eset1=new HashSet<>();
		eset1.add(e1);
		eset1.add(e2);
		Set<Employee> eset2=new HashSet<>();
		eset2.add(e3);
		eset2.add(e4);
		Department d1=new Department(10,"Hr","Pune",eset1);
		Department d2=new Department(11,"Purchase","Mumbai",eset2);
		e1.setDept(d1);
		e2.setDept(d1);
		e3.setDept(d2);
		e4.setDept(d2);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(d1);
		session.save(d2);
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tr.commit();
	}

}
