<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Time</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/time" method="POST" modelAttribute="time">
				<c:if test="${notUnique}">
					<div class="row">
						<div class="col-10 ml-auto">
							<span class="text-danger">Time already exists</span>
						</div>
					</div>
				</c:if>
				<c:if test="${emptyTime}">
					<div class="row">
						<div class="col-10 ml-auto">
							<span class="text-danger">This field must be filled</span>
						</div>
					</div>
				</c:if>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="time">Time:</label>
						<div class="col-5">
							<form:input class="form-control" id="time" path="time"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/admin/time/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Time</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="time" items="${times}">
						<tr>
							<td>${time.time}</td>
							<td class="text-center">
								<a href="/admin/time/update/${time.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<!-- <a href="/admin/time/delete/${time.id}" class="btn btn-outline-danger btn-sm">Delete</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>