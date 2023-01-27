<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div class="container-fluid">
		<nav class="navbar w-100 bg-dark bg-gradient">
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
		<div class="row">
			<div class="col-1">
				<a href="<%=request.getContextPath()%>/appointment/list"><img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrteWa5kwgakYsbtnNHUsE_oWAoIt4F-ONhg&usqp=CAU"
					alt="back" style="width: 20px; height: 20px"></a>
			</div>
			<div class="col">
				<h2 class="p-3">Bill</h2>
			</div>
		</div>
		<form:form modelAttribute="bill" method="get">
			<form:hidden path="billId" />

			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Appointment Id</label>
				</div>
				<div class=col-4>
					<form:input path="appointmentId" class="form-control"
						id="appointmentId" type="text" disabled="true" />
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Appointment Date</label>
				</div>
				<div class=col-4>
					<form:input path="appointment.appointmentDate" class="form-control"
						type="date" disabled="true" />
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Patient Name</label>
				</div>
				<div class=col-4>
					<form:input path="appointment.patient.firstName"
						class="form-control" type="text" disabled="true" />
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Doctor Name</label>
				</div>
				<div class=col-4>
					<form:input path="appointment.doctor.staff.fullName" class="form-control"
						type="text" disabled="true" />
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Total Fees</label>
				</div>
				<div class=col-4>
					<form:input path="amount" class="form-control" type="number"
						disabled="true" />
				</div>
			</div>
			<div class="row pt-3">
				<div class="col-6 m-auto">

					<button class="btn btn-dark bg-gradient" type="button" onclick="window.location.href='<%=request.getContextPath()%>/appointment/list'">Back</button>
				</div>
			</div>
		</form:form>
	</div>
	<script>
		
	</script>
</body>
</html>