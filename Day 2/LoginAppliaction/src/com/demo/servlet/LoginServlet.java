package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//retrive username and password
		String unm=request.getParameter("uname");
		String passwd=request.getParameter("pass");
		if(unm.equals("admin") && passwd.equals("admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("Formdata.html");
			rd.forward(request, response);
		}else {
			out.println("Wrong credentials , pls re-eneter");
			RequestDispatcher rd=request.getRequestDispatcher("LoginPage.html");
			rd.include(request, response);
			out.print("testing");
			
		}
		
	}

}
