package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/insertproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService ps=new ProductServiceImpl();
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pnm=request.getParameter("pname");
		int qty=Integer.parseInt(request.getParameter("qty"));
		double price=Double.parseDouble(request.getParameter("price"));
		Product p=new Product(pid,pnm,qty,price);
		boolean status=ps.addProduct(p);
		RequestDispatcher rd=request.getRequestDispatcher("displayproduct");
		rd.forward(request, response);
	}

}
