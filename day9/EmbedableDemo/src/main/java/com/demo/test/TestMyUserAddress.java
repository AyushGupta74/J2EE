package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestMyUserAddress {
	public static void main(String[] args) {
		Address addr=new Address(1,"baner","pune");
		Address addr1=new Address(1,"Deccan","pune");
		MyUser u1=new MyUser(10,"xxx",addr);
		MyUser u2=new MyUser(11,"yyy",addr1);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(u1);
		sess.save(u2);
		
		tr.commit();
		
	}
}
