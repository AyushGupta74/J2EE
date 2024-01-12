package com.demo.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.demo.model.HelloWorld;
import com.demo.model.MyUser;

public class TestHello {

	public static void main(String[] args) {
		//BeanFactory bc=new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		System.out.println("before");
		HelloWorld hello=(HelloWorld) ctx.getBean("hw");
		System.out.println("after");
		System.out.println(hello.sayHello());
		HelloWorld hello1=(HelloWorld) ctx.getBean("hw");
		System.out.println(hello1.sayHello());
		MyUser user1=(MyUser) ctx.getBean("u1");
		System.out.println(user1);
		MyUser user3=(MyUser) ctx.getBean("u3");
		System.out.println(user3);
	}

}
