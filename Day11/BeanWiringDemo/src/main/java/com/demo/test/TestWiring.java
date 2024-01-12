package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.MyUSer;
import com.demo.model.Student;

public class TestWiring {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyUSer u1=(MyUSer) ctx.getBean("u1");
		System.out.println(u1);
		Student s=(Student)ctx.getBean("st1");
		System.out.println(s);
		((ClassPathXmlApplicationContext)ctx).close();

	}

}
