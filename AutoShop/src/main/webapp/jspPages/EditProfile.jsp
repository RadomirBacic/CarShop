<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit user details</title>
</head>
<body>
	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
	<h1>Edit user with username: ${user.userName}</h1>
	<a href="Seller.jsp">Back to seller page</a> <br> <br>
	
	<form action="../EditProfileController" method="post">
		
		First name: <input type="text" name="firstName"> <br> <br>
		Last name: <input type="text" name="lastName"> <br> <br>
		Phone: <input type="text" name="phone"> <br> <br>
		Email: <input type="text" name="email"> <br> <br>
		Country: <input type="text" name="country"> <br> <br>
		City: <input type="text" name="city"> <br> <br>
		Street: <input type="text" name="street"> <br> <br>
		<input type="hidden" name="idUser" value="${user.idUser}"> <br> <br>
		
		<input type="submit" value="EDIT">
	
	</form>
</body>
</html>