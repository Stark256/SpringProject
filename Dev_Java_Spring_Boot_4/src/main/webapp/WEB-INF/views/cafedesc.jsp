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
<title>CafeDesc</title>
<style>
.one{
border:2px solid black;
}
.two{
margin:5px;

border:1px solid black;
}
</style>
</head>
<body>
	<div class="container">
			<div class="row one">
				<div class="col-12">
					<div class="row">
						<div class="col-1 two">Photo</div>				
						<div class="col-10">
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-6">${cafe.name}</div>
										<div class="col-6">${cafe.type}</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-6">${cafe.address}</div>
										<div class="col-6">${cafe.phone}</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-12">${cafe.open.time}-${cafe.close.time}</div>
							</div>
							<div class="row">
								<div class="col-12">${cafe.fullDescription}</div>
							</div>
						</div>
					</div>
				</div>
				
		</div>
		<div class="row">
			<div class="form-group row">
				<div class="col-12">
	         		<input name="rate" type="radio" id="1" value="1">
	         		<label for="1">1</label>
	         		<input name="rate" type="radio" id="2" value="2">
	         		<label for="2">2</label>
	         		<input name="rate" type="radio" id="3" value="3">
	         		<label for="3">3</label>
	         		<input name="rate" type="radio" id="4" value="4">
	         		<label for="4">4</label>
	         		<input name="rate" type="radio" id="5" value="5">
	         		<label for="5">5</label>
				</div>
			</div> 
			
			</div> 
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
		
		<form:form action="/cafedesc/${cafe.id}" method="POST" modelAttribute="comment">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" id="user" path="user"/>
						</div>
					</div>
					 <div class="form-group row">
						<label class="col-2 col-form-label" for="comment">Comment:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="comment"
								path="comment" rows="5"></form:textarea>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafedesc/${cafe.id}/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
		
		
		<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>User</th>
							<th>Comment</th>
							<th>Like</th>
							<th>Dislike</th>
						<tr>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.user}</td>
							<td>${comment.comment}</td>
							<td>${comment._like}</td>
							<td>${comment.dislike}</td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		
	</div>
</body>
</html>