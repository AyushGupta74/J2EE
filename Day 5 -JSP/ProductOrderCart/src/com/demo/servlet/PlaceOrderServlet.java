package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/placeorder")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btn=request.getParameter("btn");
		switch(btn) {
		case "add":
			RequestDispatcher rd1=request.getRequestDispatcher("findallprices");
			rd1.forward(request, response);
			break;
		case "order":
			RequestDispatcher rd=request.getRequestDispatcher("thankyoupage.jsp");
			rd.forward(request, response);
			break;
		}
	}

	
}
