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
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editproduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//will display the selected product in the form for updation
	//once you click on update button, then the data will be send to the databse for updatipon
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session=request.getSession();
		MyUser user=(MyUser) session.getAttribute("user");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(user!=null && user.getRole().equals("admin")) {
			int pid=Integer.parseInt(request.getParameter("pid"));
			ProductService ps=new ProductServiceImpl();
			Product p=ps.getById(pid);
			out.println("<h3>Welcome "+user.getUname()+"</h3>");
			
			out.println("<form action='updateproduct' method='post'>");
			out.println("Product Id: <input type='text' name='pid' id='pid' value='"+p.getPid()+"' readonly><br>"); 
			out.println(" Product Name:<input type='text' name='pname' id='pname' value='"+p.getPnm()+"'><br>");   
			out.println("Quantity : <input type='text' name='qty' id='qty' value='"+p.getQty()+"'><br>"); 
			out.println(" Price: <input type='text' name='price' id='price' value='"+p.getPrice()+"'><br>");  
			out.println("<button type='submit' name='btn' id='btn'>Update Product</button>");  
			out.println("</form>");
		}else {
			System.out.println("reached without login");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			out.println("Pls enetr credentials!!");
			rd.include(request, response);
		}
			   
		
		}

	
}
