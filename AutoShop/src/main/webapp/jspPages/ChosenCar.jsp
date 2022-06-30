<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="model.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chosen car page</title>
</head>
	<body>
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<jsp:useBean id="listOfCarslistOfCars" scope="request" class="java.util.ArrayList"></jsp:useBean>
		<h1>Welcome ${user.userName} to list of cars</h1>
		
		<p>In chosen list we have: ${listOfCars.size()} cars</p>
		
		<a href="jspPages/Buyer.jsp">Back to buyer page</a> 
		<br> <br>
		
		<table border="1px">
			<tr>
				<th>Manufacturer</th>
				<th>Model</th>
				<th>Price</th>
				<th>Year</th>
				<th>Register</th>
				<th>Buy</th>
			</tr>
			
			<c:forEach var="la" items="${listOfCars}">
				<tr>
					<td>${la.manufacturer }</td>
					<td>${la.model }</td>
					<td>${la.price }</td>
					<td>${la.year }</td>
					<td>${la.isRegister }</td>
					<td> 
						<c:url var="Info" value="InfoOfBuyingController">
							<c:param name="idCar" value="${la.idCar}"/>
							<c:param name="idUser" value="${user.idUser}"/>
						</c:url>
						<a href="${Info}"><button>Info and buying</button></a>	
					</td>
					
				</tr>
			</c:forEach>
		</table>
		
		
		
		
		
	</body>
</html>