<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Cafe</title>
</head>
<body>
	<div class="container">		
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<c:forEach var="cafe" items="${cafes}">
						<tr>
							<td>${cafe.name}</td>
							<td>${cafe.address}</td>
							<td>${cafe.shortDescription}</td>
							<td>${cafe.type}</td>
						<!-- 	<td class="text-center"><a
								href="/admin/cafe/update/${cafe.id}"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/admin/cafe/delete/${cafe.id}"
								class="btn btn-outline-danger btn-sm">Delete</a></td>
						</tr> -->
					</c:forEach>
				</table>
			</div>
		</div>
		<a href="/admin">Admin</a>
	</div>
</body>
</html>