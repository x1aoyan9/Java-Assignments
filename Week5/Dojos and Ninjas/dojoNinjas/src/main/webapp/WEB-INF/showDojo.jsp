<!-- Here we have to import the Date class. -->
<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>Display Dojo</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/main.css">
	</head>

	<body>
		<div class="container">
			<h1><c:out value="${dojo.name}"/></h1>
			<div class="actions-bar">
				<a href="index.jsp" id="index">Home</a>
				<a href="editDojo.jsp" id="editDojo">Edit Dojo</a>
				<a href="/dojos/delete/{id}">Delete Dojo</a>
			</div>
			<ul>
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<li><a href="/ninjas/{id}"><c:out value="${ninja.fName}"/><c:out value="${ninja.lName}" /></a></li>
				</c:forEach>
			</ul>
		</div>
	</body>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
</html>