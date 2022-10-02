<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<!-- c:out / c:forEach / etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- formatting dates -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!-- render errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />  <!-- for Bootstrap CSS -->
		<link rel="stylesheet" type="text/css" href="/css/style.css">  <!-- local CSS styling -->
		<title>Index</title>
	</head>

	<body>
		<div class="container">
		<h1>Save Travels</h1>
			<div class="col">
				<table>
					<thead>
						<tr>
							<th>Expense:</th>
							<th>Vendor:</th>
							<th>Description:</th>
							<th>Amount:</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="eachExp" items="${expenses}">
						<tr>
							<td>
								<a href="/expenses/${eachExp.id}">
									<c:out value="${eachExp.expenseName}"/>
								</a>
							</td>
							<td><c:out value="${eachExp.vendor}"/></td>
							<td><c:out value="${eachExp.description}"/></td>
							<td><c:out value="${eachExp.amount}"/></td>
							<td>
								<form action="/expenses/${eachExp.id}">
									<input type="hidden" name="_method" value="delete"/>
									<input type="submit" value="Delete" class="btn-danger"/>
								</form>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
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
					<input type="submit" value="Add" class="form-btn"/>
				</form:form>
			</div>
		</div>
	</body>
<script src="/webjars/jquery/jquery.min.js"></script>  <!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app.js"></script>  <!-- local JS -->
</html>