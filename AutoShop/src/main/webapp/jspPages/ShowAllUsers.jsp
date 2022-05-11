<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all users</title>
</head>
	<body>
		
		<%
			User user = (User)session.getAttribute("user");
		%>
		<h1>Welcome admin <%=user.getUserName() %></h1>
		<a href="jspPages/Admin.jsp">Back to ADMIN page</a>
		
		<p>Search all users</p>
		<form action="../AdminController" method="get"> 
		
			<input type="submit" value="Search">
		
		
		</form>
		
		<%
		List<User> listOfUsers = (List<User>)request.getAttribute("listOfUsers");
		
		%>
		
		<table border="1px">
			<tr>
				<th>ID</th>
				<th>USERNAME</th>
				<th>PASSWORD</th>
				<th>TYPE USER</th>
			</tr>
			
			<%
			if(listOfUsers != null) {
			for(User u: listOfUsers){
			%>
			
			<tr>
				<td><%=u.getIdUser() %></td>
				<td><%=u.getUserName() %></td>
				<td><%=u.getPassword() %></td>
				<td><%=u.getTypeUser() %></td>
			</tr>
			
			<%
			}
			}
			%>
		</table>
		
	</body>
</html>