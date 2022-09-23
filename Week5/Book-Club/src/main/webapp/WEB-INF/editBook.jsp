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
		<title>Edit Book</title>
		<!-- Bootstrap -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/style.css">
	</head>

	<body>
		<div class="container-fluid">
			<h2>Change Your Entry</h2>
			<form:form action="/books/${book.id}" method="post" modelAttribute="book">
				<input type="hidden" name="_method" value="put"/>
				<div class="form-group">
					<form:label path="bTitle">Title:</form:label>
					<form:errors path="bTitle"/>
					<form:input path="bTitle"/>
				</div>
				<div class="form-group">
					<form:label path="bAuthor">Author:</form:label>
					<form:errors path="bAuthor"/>
					<form:input path="bAuthor"/>
				</div>
				<div class="form-group">
					<form:label path="bNote">My Thoughts:</form:label>
					<form:errors path="bNote"/>
					<form:input path="bNote"/>
				</div>
				<div>
					<input type="submit" value="Update"/>
				</div>
			</form:form>
			<form action="books/delete/${book.id}" method="post">
				<input type="hidden" name="_method" value="destroyBook">
				<input type="submit" value="Delete">
			</form>
		</div>
	</body>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<!-- Local JS -->
	<script type="text/javascript" src="js/app.js"></script>
</html>