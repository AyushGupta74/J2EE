<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.html" %>
<form action="calculate.jsp">
Num1: <input type="text" name="num1" id="num1"><br>
Num2: <input type="text" name="num2" id="num2"><br>
<button type="submit" name="btn" id="btn" value="add">Add numbers</button>
<button type="submit" name="btn" id="fact" value="fact">Find factorial</button>
<%@include file="footer.html" %>
</form>

</body>
</html>