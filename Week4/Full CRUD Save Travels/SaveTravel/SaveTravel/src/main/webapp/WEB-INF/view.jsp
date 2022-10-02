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
        <title>View</title>
    </head>
	<body>
		<div class="container">
			<h1>Save Travels</h1>
			<h3>Expense Details:</h3>
			<a href="/">Home</a>
			<table>
				<thead>
					<tr>
						<th>Expense:</th>
						<th>Vendor:</th>
						<th>Description:</th>
						<th>Amount:</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:out value="${expense.expenseName}"/></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td><c:out value="${expense.description}"/></td>
						<td><c:out value="${expense.amount}"/></td>
					</tr>
				</tbody>
			</table>
			<a href="/expenses/edit/{id}"></a>
			<a href="/expenses/delete/{id}"></a>
		</div>
	</body>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- local JS -->
<script type="text/javascript" src="js/app.js"></script>
</html>