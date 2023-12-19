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
 * Servlet implementation class DisplayAllProduct
 */
@WebServlet("/displayAllProduct")
public class DisplayAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps=new ProductServiceImpl();
		List<Product> plist=ps.getAllProducts();
		request.setAttribute("plist", plist);
		RequestDispatcher rd=request.getRequestDispatcher("displaypeoduct.jsp");
		rd.forward(request, response);
	}

}
