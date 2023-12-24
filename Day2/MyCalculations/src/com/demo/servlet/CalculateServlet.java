package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet{
	public int factorial(int n) {
		int f=1;
		for(int i=1;i<=n;i++) {
			f=f*i;
		}
		return f;
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int num1=Integer.parseInt(request.getParameter("num1"));
		String op=request.getParameter("btn");
		switch(op) {
		case "add":
			int num2=Integer.parseInt(request.getParameter("num2"));
			int s=num1+num2;
			out.println("Addition of "+num1+" and "+num2 +" = "+s);
			break;
		case "fact":
			s=factorial(num1);
			out.println("Factorial of "+num1+" = "+s);
			
			break;
		}
		out.println("<h3>End of the calculation</h3>");
		
		
	}
	

}
