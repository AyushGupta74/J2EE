package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		LoginService ls=new LoginServiceImpl();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		MyUser user=ls.validateUser(uname,pass);
		System.out.println(user);
		if(user!=null) {
			out.println("you are "+user.getRole());
		}
		else {
			out.println("Wrong credentials, pls renter");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);
		}
		
	}

}
