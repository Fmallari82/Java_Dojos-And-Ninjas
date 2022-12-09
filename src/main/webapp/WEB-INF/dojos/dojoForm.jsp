<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Create a Dojo</title>
</head>
<body>
	<div class="container m3">
		<h1 class="text-center">New Dojo</h1>
		<form:form action="/dojos/new" method="post"
			modelAttribute="dojo">
			<div class="form-group">
				<form:label path="name">Name: </form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</div>
			<input type="submit" value="Submit" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>