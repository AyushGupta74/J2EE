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
<table>
<tr>
   <th>Product id</th>
   <th>Product name</th>
   <th>Product qty</th>
   <th>Product price</th>
</tr>

<c:forEach var="prod" items="${plist}">
   <tr>
   <td>${prod.pid}</td>
   <td>${prod.pnm}</td>
   <td>${prod.qty}</td>
   <td>${prod.price}</td>
   </tr>
</c:forEach>
</table>
</body>
</html>