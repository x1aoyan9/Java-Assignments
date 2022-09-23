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
        <!-- for Bootstrap CSS -->
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
        <!-- local CSS styling -->
        <link rel="stylesheet" type="text/css" href="/css/style.css">
        <title>Edit</title>
    </head>

	<body>
		<div class="container">
			<h1>Save Travels</h1>
			<h3>Edit an Expense:</h3>
			<form:form action="/expense/${expense.id}" method="POST" modelAttribute="expense">
				<input type="hidden" name="_method" value="PUT"/>
			</form:form>
			<br/>
			<form:form action="/expenses" method="POST" modelAttribute="expense">
				<div class="form-control">
					<form:label path="expenseName">Expense:</form:label>
					<form:errors path="expenseName" class="error"/>
					<form:input path="expense" class="form-input"/>
				</div>
				<div class="form-control">
					<form:label path="vendor">Vendor:</form:label>
					<form:errors path="vendor" class="error"/>
					<form:input path="vendor" class="form-input"/>
				</div>
				<div class="form-control">
					<form:label path="description">Description:</form:label>
					<form:errors path="description" class="error"/>
					<form:input path="description" class="form-input"/>
				</div>
				<div class="form-control">
					<form:label path="amount">Amount:</form:label>
					<form:errors path="amount" class="error"/>
					<form:input type="number" path="amount" class="form-input"/>
				</div>
				<input type="submit" value="Update" class="form-btn"/>
			</form:form>
		</div>
	</body>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
</html>