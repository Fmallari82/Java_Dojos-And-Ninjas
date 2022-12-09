<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show One</title>
</head>
<body>

	<h1 class="text-center">
		<c:out value="${dojo.name}" /> Location Ninjas
	</h1>
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojo.ninja}" var="ninja">
				<tr>
					<td>${ninja.firstName} </td>
					<td><c:out value="${ninja.lastName}" /></td>
					<td><c:out value="${ninja.age}" /></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/ninjas/new">Create Ninja</a>
	<a href="/dojos/new">Create Dojo</a>

	<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>