<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

	<div class="container-fluid">
		<nav class="navbar w-100 mb-5 bg-dark bg-gradient">
			<div class="container">
				<h1 class="text-light">Clinic Management System</h1>
				<div>
				<a href="<%=request.getContextPath()%>/login/logout"><button
						class="btn btn-bordered-light text-white">Log Out</button></a>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">

		<!-- <div class="row my-4">
			<h1>Clinic Management System</h1>
		</div> -->
		<div class="row" style="height: 70px">
			<div class="col-3 h-100">
				<a href="<%=request.getContextPath()%>/patient/list">
					<button class="btn btn-dark bg-gradient p-2 me-3">PATIENT
						LIST</button>
				</a>
			</div>
			<div class="col-3 h-100">
				<a href="<%=request.getContextPath()%>/appointment/list">
					<button class="btn btn-dark bg-gradient p-2 ms-3">APPOINTMENT
						LIST</button>
				</a>
			</div>
		</div>

	</div>
<script>
$(document).ready(function(){
	window.history.pushState(null, "", window.location.href);        

    window.onpopstate = function() {

    window.history.pushState(null, "", window.location.href);

    };
})
</script>
</body>
</html>