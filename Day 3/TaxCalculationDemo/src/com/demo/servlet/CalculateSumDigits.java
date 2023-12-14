package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateSumDigits extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	int num=Integer.parseInt(request.getParameter("n1"));
    	int s=sumofdigits(num);
    	out.println("Sum of digits of "+num+": "+s);
    	
    }

	private int sumofdigits(int num) {
		int s=0;
		while(num>0) {
			int digit=num%10;
			num=(int)num/10;
			s=s+digit;
		}
		return s;
	}
    
}
