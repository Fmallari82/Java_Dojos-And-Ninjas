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
<title>Create a Ninja</title>
</head>
<body>
	<div class="container m3">
		<h1 class="text-center">New Ninja</h1>

		<form:form action="/ninjas/new/process" method="post"
			modelAttribute="ninja">
			<div class="container">
				<form:errors style="color: red" path="*" />
			</div>
			<div class="form-group">
				<form:label path="dojo.name">Dojo: </form:label>
				<form:select path="dojo">
					<c:forEach var="dojo" items="${allDojos}">
						<form:option value="${dojo.id}">
							<c:out value="${dojo.name}" />
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
				<form:label path="age">Age: </form:label>
				<form:errors path="age" />
				<form:input path="age" />
			</div>

			<input type="submit" value="Create" />
		</form:form>
		<script type="text/javascript" src="/js/app.js"></script>
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	</div>
</body>
</html>