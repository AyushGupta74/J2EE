<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.demo.beans.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- It will display all products with checkbox -->
<form action="addToCartServlet">
<%
  List<Product> plist=(List<Product>)request.getAttribute("plist");
  for(Product p:plist){
%>
<input type="checkbox" name="prod" id="<%=p.getPid()%>" value='<%=p.getPid()+":"+p.getPnm()+":"+p.getPrice()%>'>
<label for="<%=p.getPid()%>"><%=p.getPid()+":"+p.getPnm()+":"+p.getPrice()%></label><br>
<%} %>
<Button type="submit" name="btn" id="add" value="add">Add to cart</Button>
<Button type="submit" name="btn" id="show" value="show">Show cart</Button>
</form>
</body>
</html>