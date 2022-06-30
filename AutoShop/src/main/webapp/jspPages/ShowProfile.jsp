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
<title>Show profile</title>
</head>
<body>
	
	<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
	
	<h1>User ${details.firstName} ${details.lastName} profile</h1>
	<c:if test="${user.typeUser eq 'BUYER'}">
	<a href="jspPages/Buyer.jsp">Back to buyer page</a> <br> <br>
	</c:if> 
	
	<c:if test="${user.typeUser eq 'SELLER'}">
	<a href="jspPages/Seller.jsp">Back to seller page</a> <br> <br>
	</c:if> 
	
	<img alt="Profile picture" src="profilePhotos/${details.firstName}.jfif">
	
	<table border="1px">
	
		<tr>
			<td>First name:</td>
			<td>${details.firstName}</td>
		</tr>
		
		<tr>
			<td>Last Name:</td>
			<td>${details.lastName}</td>
		</tr>
	
		<tr>
			<td>Contact:</td>
			<td>${details.contact.phone}</td>
			<td>${details.contact.email}</td>
		</tr>
		
		<tr>
			<td>Address:</td>
			<td>${details.address.country}</td>
			<td>${details.address.city}</td>
			<td>${details.address.street}</td>
		</tr>
	</table> <br>
	
	<a href="jspPages/EditProfile.jsp">Edit profile</a>
	
	
	
</body>
</html>