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
						<h1>Welcome seller ${user.userName}</h1>
					</div>
					<div class="row text-center">					
						<form class="col-md-12" action="../ProfileController" method="post">
							<input type="hidden" name="idUser" value="${user.idUser}">
							<button type="submit" class="btn btn-dark" > View profile </button>
						</form>
					<div>
					
					<form class="row d-block text-center" action="../AddCarController" method="get">
						<input type="hidden" name="idUser" value="${user.idUser}"> <br>
						<div class="col-md-6 m-auto">
							<label>Manufacturer: </label>
							<input type="text" name="manufacturer">
						</div>
						<div class="col-md-6 m-auto">
							<label> Model: </label>
							<input type="text" name="model"> 
						</div>
						<div class="col-md-6 m-auto">
							<label> Price: </label>
							<input type="text" name="price">
						</div>
						<div class="col-md-6 m-auto">
							<label>Year: </label>
							<input type="text" name="year">
						</div>
						<div class="col-md-6 m-auto">
							<label>Register </label>
							<input type="checkbox" name="isRegister">
						</div>
						<div class="col-md-12 mt-4">
							<button class="text-center btn btn-dark" type="submit" value="Add Car">Add Car </button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>