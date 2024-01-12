package com.demo.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyUser implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{
	private int uid;
	private String uname;
	public MyUser() {
		super();
		System.out.println("in Myuser default constructor");
	}
	public MyUser(int uid, String uname) {
		super();
		System.out.println("in Myuser parametrised constructor");
		this.uid = uid;
		this.uname = uname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("in Myuser uid setter method");
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		System.out.println("in Myuser uname setter method");
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + "]";
	}
	public void setBeanName(String name) {
		System.out.println("in setBeanName of BeanNameAware"+name);
		
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("in setBeanFactory of BeanFactoryAware");
		
	}
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("in setApplicationContext of ApplicationContextAware");
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("in afterPropertiesSet of InitializingBean");
		
	}
	
	public void myinit() {
		System.out.println("in custom init method");
	}
	public void destroy() throws Exception {
		System.out.println("in destory of DisposableBean");
		
	}
	public void mydestroy() {
		System.out.println("in custom destroy method");
	}
	

}
