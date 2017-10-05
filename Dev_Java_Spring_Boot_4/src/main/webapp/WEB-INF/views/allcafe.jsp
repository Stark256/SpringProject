<%@ include file="header.jsp"%>
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
				<form:form action="/yura/allcafe" method="GET" modelAttribute="cafeFilter">
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minRate" class="form-control" placeholder="Min rate"/>
						</div>
						<div class="col-6">
							<form:input path="maxRate" class="form-control" placeholder="Max rate"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minOpen" class="form-control" placeholder="Min open"/>
						</div>
						<div class="col-6">
							<form:input path="maxOpen" class="form-control" placeholder="Max open"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-6">
							<form:input path="minClose" class="form-control" placeholder="Min close"/>
						</div>
						<div class="col-6">
							<form:input path="maxClose" class="form-control" placeholder="Max close"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
							<div>
								<label>Pub <form:checkbox path="types" value="PUB"/></label>
								<label>Sushy <form:checkbox path="types" value="SUSHY"/></label>
								<label>Bar <form:checkbox path="types" value="BAR"/></label>
								<label>Cafe <form:checkbox path="types" value="CAFE"/></label>
								<label>Restaurant <form:checkbox path="types" value="RESTAURANT"/></label>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-12">
        					<button type="submit" class="btn btn-outline-success btn-sm">Search</button>
      					</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Full description</th>
						<th class="text-center">Short description</th>
						<th class="text-center">Type</th>
						<th class="text-center">Phone</th>
						<th class="text-center">Open</th>
						<th class="text-center">Close</th>
					</tr>
					<c:forEach var="cafe" items="${cafes}">
						<tr>
							<td><a href="/cafedesc/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.fullDescription}</td>
							<td>${cafe.shortDescription}</td>
							<td>${cafe.type}</td>
							<td>${cafe.phone}</td>
							<td>${cafe.open}</td>
							<td>${cafe.close}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<c:if test="${cafes!=null}">
		<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${cafes}"/>
			</div>
		</div>
		</c:if>
	</div>
</body>
</html>