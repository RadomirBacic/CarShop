<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller page</title>
</head>
	<body>
	
	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<h1>Welcome seller ${user.userName}</h1>
		
		<form action="../ProfileController" method="post">
			<input type="hidden" name="idUser" value="${user.idUser}">
			<input type="submit" value="View profile">
		</form>
		
		<form action="../AddCarController" method="get">
			<input type="hidden" name="idUser" value="${user.idUser}"> <br>
			
			Manufacturer: <input type="text" name="manufacturer"> <br>
			Model: <input type="text" name="model"> <br>
			Price: <input type="text" name="price"> <br>
		 	Year: <input type="text" name="year">
		 	Register<input type="checkbox" name="isRegister">
		 	
		 	<input type="submit" value="Add Car">
		</form>
		
	</body>
</html>