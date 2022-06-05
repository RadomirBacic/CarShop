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
<title>Cars</title>
</head>
<body>
	
	<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
	
	<h1>User ${details.firstName} ${details.lastName} profile</h1>
	<a href="jspPages/Seller.jsp">Back to HOME page</a> <br> <br> <br>
	
	<img alt="Profile picture" src="profilePhotos/${details.firstName}.jfif">
	
	
	<a href="jspPages/EditProfile.jsp">Edit profile</a>
	
	
	
	
</body>
</html>