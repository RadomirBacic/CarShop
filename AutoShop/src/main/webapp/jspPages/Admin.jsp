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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link 
	rel="stylesheet"
	type="text/css"
	href="../css/style.css">
</head>
	<body>
		<div class="container d-flex main-div">
			<div class="row align-self-center w-100">
				<div class="col-6 mx-auto main-div-shadow">
					<div class="row text-center">
						<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
						<h1>Welcome ${user.userName}</h1>
					</div>
					<form class="row d-block text-center" action="../AdminController" method="get">
						<div class="col-md-6 m-auto">
							<label>Choose which users you want to see: </label>
							<select name="typeUser" id="users">
								<option value="buyer">Buyers</option>
								<option value="seller">Sellers</option>
								<option value="all">All</option>
							</select> 
							
							<button type="submit" value="SHOW"> SHOW </button>
						</div>
						<div class="col-md-6 m-auto">
							<label>Here you can add money to a user:</label>
							<a class="btn btn-dark" href="AddBalance.jsp">Add balance</a>
						</div>
					
					</form>
				</div>
			</div>
		</div>
	</body>
</html>