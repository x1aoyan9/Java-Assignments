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
		<title>Ninja Form</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/main.css">
	</head>

	<body>
		<div class="container">
			<h2>New Ninja</h2>
			<form:form action="/ninjas" method="post" modelAttribute="ninja">
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
					<form:label path="age">Age:</form:label>
					<form:errors path="age"/>
					<form:input path="age"/>
				</div>
				<div class="form-group">
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo">
						<form:errors path="dojo"/>
						<c:forEach var="eachDojo" items="${dojos}">
							<option value="${eachDojo.id}">
								<c:out value="${eachDojo.name}"/>
							</option>
						</c:forEach>
					</form:select>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</body>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
</html>