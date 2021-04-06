<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>List Users</h2>
		<a href="UserServlet?action=AddOrEdit" class="btn btn-primary">Add
			Users</a>
		<table class="table table-bordered">
			<thead>
			
				<tr>
					<th>UserName</th>
					<th>Password</th>
					<th>FullName</th>
					<th>Age</th>
					<th>Birthday</th>
					<th>Gender</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${LIST_USERS}">
				<tr>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.fullname}</td>
					<td>${user.age}</td>
					<td><fmt:formatDate  value ="${user.birthday}" pattern="dd/MM/yyyy" /> </td>
					<td>${user.gender ? "Nam" : "Nu"}</td>
					<td><a class="btn btn-primary btn-sm"
						href="UserServlet?action=AddOrEdit&username=a3">Edit</a> | <a
						class="btn btn-danger btn-sm"
						href="UserServlet?action=Delete&username=a3">Del</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>