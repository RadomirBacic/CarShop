<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buyer page</title>
</head>
	<body>
	
		<%
			User user = (User)session.getAttribute("user");
		%>
		
		<h1>Welcome buyer <%=user.getUserName() %></h1>
		
		
	</body>
</html>