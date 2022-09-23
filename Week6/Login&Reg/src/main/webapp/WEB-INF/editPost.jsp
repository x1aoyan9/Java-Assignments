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
		<title>Edit</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/style.css">
	</head>

	<body>
		<div class="wrapper">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow">
				<div class="container-fluid mx-3">
<!-- 				<a class="navbar-brand" href="dashboard.jsp">Home</a> -->
					<h1 class="text-light pt-1">Welcome {loginUser.fName}{loginUser.lName}!</h1>
					<div>
						<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar" aria-controls="collapsibleNavbar" aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="collapsibleNavbar">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle opacity-85" href="#" role="button" data-bs-toggle="dropdown">Actions</a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="/dashboard">Dashboard</a></li>
<!-- 									<li><a class="dropdown-item" href="createPost.jsp">Create</a></li> -->
										<li><a class="dropdown-item" href="/logout">Logout</a></li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</nav>
			<div class="container-fluid mt-4">
				<h2>Edit Post</h2>
				<form:form action="/posts/${post.id}" method="post" modelAttribute="post">
					<input type="hidden" name="_method" value="put">
					<div class="form-group">
						<form:label path="posTitle">Title:</form:label>
						<form:errors path="posTitle"/>
						<form:input path="posTitle"/>
					</div>
					<div class="form-group">
						<form:label path="body">Message:</form:label>
						<form:errors path="body"/>
						<form:input path="body"/>
					</div>
					<input type="submit" value="Update"/>
				</form:form>
				<form action="posts/delete/${post.id}" method="post">
					<input type="hidden" name="_method" value="destroyPost">
					<input type="submit" value="Delete">
				</form>
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