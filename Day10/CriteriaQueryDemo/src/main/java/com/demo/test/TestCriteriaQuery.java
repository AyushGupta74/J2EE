package com.demo.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.model.Product;

public class TestCriteriaQuery {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		//retrieve all products
		//String str="select p from Product p"
		Criteria cr=session.createCriteria(Product.class);
		List<Product> plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		//find products with price >300 and qty<50
		
		Criterion pricegt=Restrictions.gt("price",300.00);
		Criterion qtylt=Restrictions.lt("qty",50);
		Criteria cr1=session.createCriteria(Product.class);
		LogicalExpression expr=Restrictions.and(pricegt, qtylt);
		cr1.add(expr);
		plist=cr1.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		//to find only first 2 records
		cr.setFirstResult(0);
		cr.setMaxResults(2);
		plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		//to find only first 2 records
		cr.setFirstResult(1);
		cr.setMaxResults(2);
		plist=cr.list();
		plist.forEach(System.out::println);
		System.out.println("************************************");
		
		//using JPQL
		System.out.println("using JPQL");
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Product> cr2=cb.createQuery(Product.class);
		Root<Product> rt=cr2.from(Product.class);
		Query q=session.createQuery(cr2.select(rt));
		plist=q.getResultList();
		plist.forEach(System.out::println);
		System.out.println("************************************");
				
		
		
		

	}

}
