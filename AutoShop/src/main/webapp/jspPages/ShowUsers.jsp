<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>     
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show users</title>
</head>
	<body>
		
	<jsp:useBean id="users" scope="request" class="java.util.ArrayList"></jsp:useBean>	
	<a href="jspPages/Admin.jsp">Back to admin page</a>	
	<h1>Table of users</h1>
	
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Password</th>
			<th>Type user</th>
		</tr>
	
		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.userName}</td>
				<td>${u.email}</td>
				<td>${u.password }</td>
				<td>${u.typeUser }</td>
			</tr>
		
		</c:forEach>
	</table>		
		
	</body>
</html>