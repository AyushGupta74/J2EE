<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Select Products</h1>
<%
   List<Double> plist=(List<Double>) request.getAttribute("prlst");

%>
<form action="displaybyprice">
<select name="price">  
<%
   for(Double ob:plist){%>
	   <option value='<%=ob%>'><%=ob%></option>
<%}%>
</select>
<button type="submit"  name="btn" id="btn" value="btn">Show Products</button>
</form>



</select>









</body>
</html>