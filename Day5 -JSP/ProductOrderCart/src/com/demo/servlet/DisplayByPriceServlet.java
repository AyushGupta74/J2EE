package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class DisplayByPriceServlet
 */
@WebServlet("/displaybyprice")
public class DisplayByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//retrive all products with price < selected price
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double pr=Double.parseDouble(request.getParameter("price"));
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getAllProductsbyprice(pr);
		request.setAttribute("plist", plist);
		RequestDispatcher rd=request.getRequestDispatcher("selectProduct.jsp");
		rd.forward(request, response);
	}

}
