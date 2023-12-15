package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//it will find, if user exists, then it will return MyUser Object, otherwise null
		MyUser user=ls.validateUser(uname,pass);
		System.out.println(user);
		if(user!=null) {
			//create a new session
			HttpSession session=request.getSession();
			//if(session.isNew()) {
			session.setAttribute("user", user);
			//}
			//if th erole of the use ris admin 
			if(user.getRole().equals("admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("displayproduct");
				rd.forward(request, response);
			}else {
				out.println("you are a user");
			}
		}
		else {
			out.println("Wrong credentials, pls renter");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request,response);
		}
		
	}

}
