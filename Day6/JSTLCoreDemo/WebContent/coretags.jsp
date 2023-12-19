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
<%int i=3; %>
<c:set var="a" value="20"></c:set>
<c:set var="i" value="4"></c:set>
Output: <c:out value="${a}"></c:out>
<c:if test="${a>10}">
    <h3>a is greater than 10</h3>
</c:if>
<c:forEach var="j" begin="1" end="10" step="1">
   <h3>Hello ${j}</h3>
</c:forEach>
<c:out value="${i}"></c:out>
<c:choose>
   <c:when test="${i==1}">Monday</c:when>
   <c:when test="${i==2}">Tuesday</c:when>
   <c:when test="${i==3}">Wednesday</c:when>
   <c:when test="${i==4}">Thursday</c:when>
   <c:otherwise>Sunday</c:otherwise>
</c:choose>
<a href="displayAllProduct">display all products</a>
</body>
</html>