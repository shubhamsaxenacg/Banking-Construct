<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style>
			.index {
				font-size: 20px;
			}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp" ></jsp:include>
		<div class="index">
			<a href="add.jsp">Create new account</a><br>
			<a href="viewAcc.app">View all accounts</a><br>
			<a href="viewCust.app">View all customers</a><br>
			<a href="search.app">Search</a><br>
			<a href="withdraw.app">Withdraw amount</a><br>
			<a href="deposit.app">Deposit amount</a><br>
			<a href="transfer.app">Fund Transfer</a><br>
		</div>
		
	</body>
</html>