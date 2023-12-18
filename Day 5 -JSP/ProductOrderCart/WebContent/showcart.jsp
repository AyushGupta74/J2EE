<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.demo.beans.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   List<Product> cart=(List<Product>)session.getAttribute("cart");

%>
<table border="2">
<tr>
  <th>Product Id</th>
  <th>Product name</th>
  <th>Quantity</th>
  <th>Price</th>
</tr>
<%
double sum=0;
for(Product p:cart){
	sum=sum+p.getPrice();
	%>
<tr>
  <td><%=p.getPid()%></td>
  <td><%=p.getPnm()%></td>
  <td><%=p.getQty()%></td>
  <td><%=p.getPrice()%></td>
</tr>
<%} %>
<tr>
   <td colspan="3">Total Bill</td>
   <td><%=sum %></td>
</tr>
</table>
<form action="placeorder">
<button type="submit" name="btn" id="order" value="order">Place order</a>
<button type="submit" name="btn" id="order" value="add">Add more products</a>
</form>
</body>
</html>