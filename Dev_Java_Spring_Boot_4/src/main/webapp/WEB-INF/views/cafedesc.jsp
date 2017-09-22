<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<a href="/admin">Admin</a>
	</div>
	
</body>
</html>