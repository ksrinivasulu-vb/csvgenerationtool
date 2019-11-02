<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Printizen CSV Tool | Batch Details</title>

</head>

<body>
	<h1>Batch Details</h1>
	<table>
		<tr>
			<th>Batch ID</th>
			<th>Batch Name</th>
			<th>Batch Size</th>
			<th>File Name</th>
			<th>Created Date</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${Batchdetails.batchdetails}" var="batchdetail"
			varStatus="tagStatus">
			<tr>
				<td>${batchdetail.batchid}</td>
				<td>${batchdetail.batchname}</td>
				<td>${batchdetail.batchsize}</td>
				<td>${batchdetail.filename}</td>
				<td>${batchdetail.createddate}</td>
				<td></td>

				<td>Delete</td>
			</tr>
		</c:forEach>
	</table>

</body>

</html>

