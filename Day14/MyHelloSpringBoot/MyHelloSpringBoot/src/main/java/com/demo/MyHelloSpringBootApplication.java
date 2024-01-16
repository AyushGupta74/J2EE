package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyHelloSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(MyHelloSpringBootApplication.class, args);
		/*for(String name:ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}*/
		
	}

}
