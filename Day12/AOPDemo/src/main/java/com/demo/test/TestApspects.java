package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.MyGame;
import com.demo.model.MyVehicleGame;

public class TestApspects {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
		MyGame g1=(MyGame) ctx.getBean("myGame");
		g1.m1();
		MyVehicleGame v1=(MyVehicleGame) ctx.getBean("myVehicleGame");
        v1.m11(10);
        v1.game1();
	}

}
