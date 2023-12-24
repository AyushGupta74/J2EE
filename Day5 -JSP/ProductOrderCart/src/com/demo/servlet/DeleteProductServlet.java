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

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/deleteproduct")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		MyUser user=(MyUser) session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(user!=null && user.getRole().equals("admin")) {
			
				int pid=Integer.parseInt(request.getParameter("pid"));
				ProductService ps=new ProductServiceImpl();
				boolean status=ps.deleteById(pid);
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
