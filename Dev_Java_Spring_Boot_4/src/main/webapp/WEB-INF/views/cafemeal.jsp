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
<title>Meal</title>
</head>
<body>
	<div class="container">		
		<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>Meal title</th>
							<th>Meal cuisine</th>
							<th>Meal weight</th>
							<th>Meal price</th>
							<th>Meal description</th>
							<th>Meal ingredients</th>
						<tr>
					<c:forEach var="meal" items="${meals}">
						<tr>
							<td>${meal.title}</td>
							<td>${meal.cuisine.name}</td>
							<td>${meal.weight}</td>
							<td>${meal.price}</td>
							<td>${meal.description}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient.name} 
								</c:forEach>
							</td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<a href="/admin">Admin</a>
	</div>
</body>
</html>