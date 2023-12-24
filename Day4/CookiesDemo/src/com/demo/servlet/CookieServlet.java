package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookiesdata")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String btn=request.getParameter("btn");
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    switch(btn) {
	    case "add":
	    	String nm=request.getParameter("nm");
		    String val=request.getParameter("val");
		    Cookie c=new Cookie(nm,val);
		    response.addCookie(c);
	    	out.println("Added successfully!! ");
	    	break;
	    case "show":
	    	Cookie[] arr=request.getCookies();
	    	for(Cookie c1:arr) {
	    		out.println(c1.getName()+"--->"+c1.getValue());
	    		
	    	}
	    	break;
	    case "delete":
	    	 nm=request.getParameter("nm");
	    	 arr=request.getCookies();
		    for(Cookie c1:arr) {
		    	if(c1.getName().equals(nm)) {
		    		//to delete set the max age to 0
		    		c1.setMaxAge(0);
		    		response.addCookie(c1);
		    		out.println("deleted successfully!! "+c1.getName());
		    	}
		    		
		    }
		    break;
	    }
	    RequestDispatcher rd=request.getRequestDispatcher("cookiesform.html");
		rd.include(request, response);
	}

}
