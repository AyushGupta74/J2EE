package com.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.model.MyUser;

public class UserDaoImpl implements UserDao{
    static SessionFactory sf;
    static {
    	sf=HibernateUtil.getMySessionFactory();
    }
	public void save(MyUser u) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(u);
		tr.commit();
		session.close();
		
	}
	@Override
	public List<MyUser> findAll() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from MyUser");
		List<MyUser> ulist=query.list();
		tr.commit();
		session.close();
		return ulist;
	}
	@Override
	public MyUser findById(int uid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u=session.get(MyUser.class,uid);
		tr.commit();
		session.close();
		return u;
	}
	@Override
	public boolean deleteById(int uid) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u=session.get(MyUser.class,uid);
		if(u!=null) {
			session.delete(u);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	@Override
	public boolean updateById(int uid, String unm, String street) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		MyUser u=session.get(MyUser.class,uid);
		if(u!=null) {
			u.setUname(unm);
			u.getAddr().setStreet(street);
			session.update(u);
			tr.commit();
			session.close();
			return true;
		}
		session.close();
		return false;
		
	}
	@Override
	public List<MyUser> sortById() {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from MyUser u order by u.uid desc");
		List<MyUser> ulist=query.list();
		tr.commit();
		session.close();
		return ulist;
	}
	@Override
	public void closeMyServiceFactory() {
		HibernateUtil.closeMySessionFactory();
		
	}

}
