<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product Details</h1>
<table border="2">
  <tr >
     <th>Product pid</th>
     <th>Product pname</th>
     <th>Quantity</th>
     <th>price</th>
     <th>action</th>
  </tr>
  <c:forEach var="p" items="${plist}">
     <tr>
       <td>${p.pid}</td>
       <td>${p.pname}</td>
       <td>${p.qty}</td>
       <td>${p.price}</td>
       <td><a href="delete/${p.pid}">delete</a>
       /
       <a href="edit/${p.pid}">edit</a></td>
     </tr>
  </c:forEach>
</table>
<a href="addproduct">Add new Product</a>
</body>
</html>