package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class FindByPriceServlet
 */
@WebServlet("/findallprices")
public class FindByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //display all prices in dropdown box
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pservice=new ProductServiceImpl();
		List<Double> prlst=pservice.findAllPrice();
		request.setAttribute("prlst",prlst);
		RequestDispatcher rd=request.getRequestDispatcher("displayprices.jsp");
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
