<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
</head>
	<body>
		
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		
		<h1>Welcome ${user.userName}</h1>
		
		<form action="../AdminController" method="get">
			Choose which users you want to see:
			<select name="typeUser" id="users">
				<option value="buyer">Buyers</option>
				<option value="seller">Sellers</option>
				<option value="all">All</option>
			</select> 
			
			<input type="submit" value="SHOW"> <br>
			Here you can add money to a user:
		<a href="AddBalance.jsp">Add balance</a>
		
		</form>
		
	</body>
</html>