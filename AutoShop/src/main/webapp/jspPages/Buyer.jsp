<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buyer page</title>
</head>
	<body>
		<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
		<h1>Welcome buyer  ${user.userName}</h1>
		
		<form action="../ProfileController" method="post">
			<input type="hidden" name="idUser" value="${user.idUser}">
			<input type="submit" value="View profile">
		</form>
		<a href="Logout.jsp" class="LogoutLink"><button type="button" class="btn btn-outline-info">Log out</button> </a>
		
	<p>Search cars: </p>	 
		<form action="../ChosenCarController" method="get">
			Manufacturer: <input type="text" name="manufacturer"> <br>
			Model: <input type="text" name="model"> <br>
			Price from: <input type="text" name="priceFrom"> <br>
			Price to: <input type="text" name="priceTo"> <br>
			Year from: <select name="yearFrom">
					<option value="0"> </option>
					<c:forEach var="i" begin="1950" end="2022">
						<option value="${i}"> ${i} </option>
					</c:forEach>
			
				</select>
			
			Year to: <select name="yearTo">
					<option value="0"> </option>
					<c:forEach var="i" begin="1950" end="2022">
						<option value="${i}"> ${i} </option>
					</c:forEach>
			
				</select>
			<br>
			Registration: <select name = "registration">
							<option value="1"> Register</option>
							<option value="0"> Not register</option>
							<option value="2"> All</option>
						</select>	
			<br>
			<input type="submit" value="Search">
		
		</form>
	</body>
</html>