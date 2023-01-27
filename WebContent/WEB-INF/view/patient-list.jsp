<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient List</title>
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
	<div class="container pt-4">
		<form:form action="search" method="get">

			<div class="row py-3">

				<div class="col-6">

					<input type="text" name="phoneNumber"
						class="form-control border border-2"
						placeholder="Search by Phone Number">

				</div>
				<div class="col-3">
					<button class="btn btn-dark bg-gradient" type="submit"
						onclick="window.location.href=<%request.getParameter("phoneNumber");%>; return false;">Search</button>

				</div>
				<div class="col-3">
					<button class="btn btn-dark bg-gradient float-end"
						onclick="window.location.href='add'; return false;">Add
						Patient</button>
				</div>
			</div>
		</form:form>

		<table class="table table-bordered">
			<tr>
				<th>Patient ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Blood Group</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Phone Number</th>
				<th>Email ID</th>
				<th colspan="2">Manage</th>
				<th>Appointment</th>
			</tr>

			<f:forEach var="patient" items="${patients}">

				<f:url var="updatelink" value="/patient/update">
					<f:param name="patientId" value="${patient.patientId}" />
				</f:url>

				<f:url var="deletelink" value="/patient/delete">
					<f:param name="patientId" value="${patient.patientId}" />
				</f:url>

				<f:url var="bookAppointment" value="/appointment/add">
					<f:param name="patientId" value="${patient.patientId}" />
					<f:param name="appointmentId" value="0" />
				</f:url>

				<f:if test="${patient.isActive}">

					<tr>
						<td>${patient.patientId}</td>
						<td>${patient.firstName}</td>
						<td>${patient.lastName}</td>
						<td>${patient.gender}</td>
						<td>${patient.bloodGroup}</td>
						<td>${patient.dateOfBirth}</td>
						<td>${patient.address}</td>
						<td>${patient.phoneNumber}</td>
						<td>${patient.email}</td>
						<td><button class="btn btn-dark bg-gradient"
								onclick="window.location.href='${updatelink}'; return false;">Update</button></td>
						<td><button class="btn btn-dark bg-gradient deleteBtn"
								onclick="getDetails(${patient.patientId})">Delete</button></td>
						<td><button class="btn btn-dark bg-gradient"
								onclick="window.location.href='${bookAppointment}'; return false;">Book</button></td>
					</tr>
				</f:if>
			</f:forEach>
		</table>
		<div class="row pt-3">
			<div class="col">
				<a href="<%=request.getContextPath()%>/receptionist-home"><button
						class="btn btn-dark bg-gradient mb-5">Back to Home</button></a>
			</div>
		</div>
	</div>
	<script>

	var patId = 0;
	function getDetails(patientId){
		console.log(patientId);
		patId = patientId;
		}
	
	$(document).ready(function(){

		window.history.pushState(null, "", window.location.href);        

	    window.onpopstate = function() {

	    window.history.pushState(null, "", window.location.href);

	    };

		var deleteUrlJs = '';

		$('.deleteBtn').click(function(){
			console.log("check");
			if(window.confirm('Do you want to cancel this patient?')) {
				<f:url var="deletelink" value="/patient/delete">
					<f:param name="patientId" value="" />
				</f:url>
				window.location.href='${deletelink}'+patId;
		    }
			});
		})
	</script>
</body>
</html>