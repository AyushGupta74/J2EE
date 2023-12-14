package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class DisplayProductServlet
 */
@WebServlet("/displayproduct")
public class DisplayProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ProductService ps=new ProductServiceImpl();
		List<Product> plist=ps.getAllProducts();
		out.println("<table border='2'><tr><th>Product Id </th><th>Name</th><th>Quantity</th><th>Price</th><th>Action</th></tr>");
		for(Product p:plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPnm()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td>");
			out.println("<td><a href='#'>delete</a> / <a href='#'>edit</a> </td> </tr>");
		}
		out.println("</table>");
		out.print("<a href='addproduct.html'>Add new Product</a>");
	}

}
