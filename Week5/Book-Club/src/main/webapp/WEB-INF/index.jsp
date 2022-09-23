<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login / Registration</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/style.css">
	</head>

	<body>
		<div class="container-fluid">
		<h1>Book Club</h1>
			<div class="col">
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="user">
					<div class="form-group">
						<form:label path="fName">First Name:</form:label>
						<form:errors path="fName"/>
						<form:input path="fName"/>
					</div>
					<div class="form-group">
						<form:label path="lName">Last Name:</form:label>
						<form:errors path="lName"/>
						<form:input path="lName"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:errors path="email"/>
						<form:input path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:errors path="password"/>
						<form:input path="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirmPass">Confirm Password:</form:label>
						<form:errors path="confirmPass"/>
						<form:input path="confirmPass"/>
					</div>
					<div>
						<input type="submit" value="Register"/>
					</div>
				</form:form>
			</div>
			<div class="col">
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="user">
					<div class="form-group">
						<form:label path="email">Email:</form:label>
						<form:errors path="email"/>
						<form:input path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password:</form:label>
						<form:errors path="password"/>
						<form:input path="password"/>
					</div>
					<div>
						<input type="submit" value="Login"/>
					</div>
				</form:form>
			</div>
		</div>
	</body>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<!-- Local JS -->
	<script type="text/javascript" src="js/app.js"></script>
</html>