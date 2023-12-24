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
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/insertproduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //retrieve the data from the addproduct.html file, and add new record in the product table    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MyUser user=(MyUser) session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(user!=null && user.getRole().equals("admin")) {
			ProductService ps=new ProductServiceImpl();
			int pid=Integer.parseInt(request.getParameter("pid"));
			String pnm=request.getParameter("pname");
			int qty=Integer.parseInt(request.getParameter("qty"));
			double price=Double.parseDouble(request.getParameter("price"));
			Product p=new Product(pid,pnm,qty,price);
			//data will be added in the product table
			boolean status=ps.addProduct(p);
			//control will be transfered back to displayproduct
			RequestDispatcher rd=request.getRequestDispatcher("displayproduct");
			rd.forward(request, response);
		}else {
			System.out.println("reached without login");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			out.println("Pls enetr credentials!!");
			rd.include(request, response);
		}
	}

}
