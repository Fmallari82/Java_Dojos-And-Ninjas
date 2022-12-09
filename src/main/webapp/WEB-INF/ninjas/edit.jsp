<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit</title>
</head>
<body>
	<div class="container m3">
		<h1>Edit Ninja</h1>
		<form:form action="/ninjas/edit/process/${ninja.id}" method="post" modelAttribute="language">
	<input type="hidden" name="_method" value="put">
\		<div class="form-group">
				<form:label path="name">Name: </form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${allDojos}">
						<form:option value="${dojo.id} path="dojo">
							<c:out value="${dojo.name}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="firstName">First Name: </form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" />
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name: </form:label>
				<form:errors path="lastName" />
				<form:input path="lastName" />
			</div>
			<div class="form-group">
				<form:label path="lastName">Age: </form:label>
				<form:errors path="lastName" />
				<form:input type="number" path="lastName" />
			</div>

		<input type="submit" value="Submit" />
	</form:form>
	
<script type="text/javascript" src="/js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</div>
</body>
</html>