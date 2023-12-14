package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculatorServlet extends HttpServlet{
	private double slab1,slab2;
	private String contextp1="";
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext context=this.getServletContext();
		contextp1=context.getInitParameter("c1");
		System.out.println("in init of taxcalulater");
		slab1=Double.parseDouble(config.getInitParameter("s1"));
		slab2=Double.parseDouble(config.getInitParameter("s2"));
	}
	public void init() {
		ServletConfig c=this.getServletConfig()
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		double tax=0;
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		double netamt=Double.parseDouble(request.getParameter("amt"));
		double invest=Double.parseDouble(request.getParameter("invest"));
		double amt=netamt;
		if(invest<100000) {
			netamt=netamt-invest;
		}else {
			netamt=netamt-100000;
		}
		if(netamt<slab1) {
			tax=0;
		}
		netamt=netamt-slab1;
		if(netamt<slab2) {
			tax=netamt*0.20;
			
		}else {
			tax=slab2*0.20;
			tax=tax+(netamt-slab2)*0.30;
		}
		out.println("The amount :"+amt+"<br>");
		out.println("Investments :"+invest+"<br>");
		out.println("The tax amount: "+tax+"<br>");
	}
	
	public void destroy(){
		System.out.println("in taxcalculatedestroy method");
	}

}
