<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add balance</title>
</head>
	<body>
		<h1>Add balance</h1>
		
		<a href="Admin.jsp">Back to ADMIN page</a>
		
		<form action="../AddBalanceController" method="get">
			Username: <input type="text" name="userName"> <br>
			Balance: <input type="text" name="balance"> <br> <br>
			<input type="submit" value="Add balance">
			
		
		</form>
	</body>
</html>