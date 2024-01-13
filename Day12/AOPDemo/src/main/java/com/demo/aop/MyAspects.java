package com.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspects {
	@After("execution(* com.demo.model.*.*(..))")
	public void addpoint() {
		System.out.println("in after addpoint advice");
		
	}

	@Before("execution(* com.demo.model.*.*(..))")
	public void deductpoints() {
		System.out.println("in before deductpoint advice");
	}
	
	@After("execution(* com.demo.model.*.*(..))")
	public void writeToFile() {
		System.out.println("in after writetofile advice");
	}
	@Around("execution(* com.demo.model.*.m11(..))")
	public Object arroundAdvice(ProceedingJoinPoint joinpoint) {
		System.out.println("line1 before function call in around advice");
		System.out.println("line1 before function call in around advice");
		Object ob=null;
		try {
			ob=joinpoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("line1 after function call in around advice");
		System.out.println("line1 after function call in around advice");
		return ob;
	}
}
