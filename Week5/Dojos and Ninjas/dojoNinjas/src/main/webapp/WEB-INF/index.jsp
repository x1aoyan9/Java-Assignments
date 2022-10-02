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
		<title>Landing Page</title>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
		<!-- Local CSS -->
		<link rel="stylesheet" href="/css/main.css">
	</head>

	<body>
		<div class="container">
		<h1>Class is in session!</h1>
			<div class="actions-bar">
				<a href="dojoForm.jsp" id="dojoForm">Add Dojo</a>
				<a href="ninjaForm.jsp" id="ninjaForm">Add Ninja</a>
			</div>
			<div class="form-search">
				<form:form action="/dojos" method="post" modelAttribute="dojo">
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo">
						<c:forEach var="eachDojo" items="${dojos}">
							<option value="${eachDojo.id}">
								<c:out value="${eachDojo.name}"/>
							</option>
						</c:forEach>
					</form:select>
					<input type="submit" value="View"/>
				</form:form>
			</div>
		</div>
	</body>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
</html>