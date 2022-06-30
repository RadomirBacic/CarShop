<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="model.UserDetails"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit successfully</title>
</head>
<body>
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<h1>User ${user.userName}</h1>
		
		<h1>You are edit your profile successfully</h1>
		
		
	<c:if test="${user.typeUser eq 'BUYER'}">
	<a href="../jspPages/Buyer.jsp">Back to buyer page</a> <br> <br>
	</c:if> 
	
	<c:if test="${user.typeUser eq 'SELLER'}">
	<a href="../jspPages/Seller.jsp">Back to seller page</a> <br> <br>
	</c:if> 
</body>
</html>