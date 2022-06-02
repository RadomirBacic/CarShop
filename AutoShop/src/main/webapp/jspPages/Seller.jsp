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
		<h1>Welcome ${user.userName}</h1>
		
		<a href="EditProfile.jsp">Edit your profile</a>
		
		
	</body>
</html>