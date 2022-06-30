<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="model.Car" %>
<%@ page import="model.UserDetails" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info and buying</title>
</head>
<body>
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<jsp:useBean id="car" scope="request" class="model.Car"></jsp:useBean> 
		<jsp:useBean id="details" scope="request" class="model.UserDetails"></jsp:useBean>
		
	<h1>Info of car</h1>
	
	<p>Buyer: ${user.userName}</p>
	<p>Balance: ${details.balance}</p>
	
	<p>Seller: ${car.userDetails.firstName}  ${car.userDetails.lastName}</p>
		
</body>
</html>