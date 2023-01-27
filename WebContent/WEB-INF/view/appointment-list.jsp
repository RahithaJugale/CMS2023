<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment List</title>
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
		<div class="row py-3">
			<div class="col-7">
				<form:form action="search" method="get">
					<div class="row">

						<div class="col-6">

							<input type="text" name="patientName"
								class="form-control border border-2"
								placeholder="Search by Patient Name">

						</div>
						<div class="col-3">
							<button class="btn btn-dark bg-gradient" type="submit"
								onclick="window.location.href=<%request.getParameter("patientName");%>; return false;">Search</button>

						</div>
					</div>
				</form:form>
			</div>
			<div class="col-5 float-end">
				<form:form action="filter" method="get">
					<div class="row">
						<div class="col-4">

							<input type="date" class="form-control" name="appointmentDate"
								id="filterDate">

						</div>
						<div class="col-1">
							<button class="btn btn-dark bg-gradient" type="submit"
								id="filterBtn"
								onclick="window.location.href=<%request.getParameter("appointmentDate");%>; return false;">Filter</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>

		<table class="table table-bordered" id="appointmentTable">
			<tr>
				<th>Appointment ID</th>
				<th>Patient Name</th>
				<th>Doctor Name</th>
				<th>Specialization</th>
				<th>Appointment Date</th>
				<th>Token Number</th>
				<!-- <th colspan="2">Manage</th> -->
				<th>Manage</th>
				<th>Bill</th>
			</tr>

			<f:forEach var="appointment" items="${appointments}">
				<f:set var="isBillPresent" value="false" />
				<f:forEach var="bill" items="${bills}">
					<f:if test="${appointment.appointmentId == bill.appointmentId}">
						<f:set var="isBillPresent" value="true" />
					</f:if>
				</f:forEach>

				<%-- <f:url var="updatelink" value="/appointment/update">
					<f:param name="appointmentId" value="${appointment.appointmentId}" />
				</f:url> --%>

				<f:url var="checkoutLink" value="/appointment/bill">
					<f:param name="appointmentId" value="${appointment.appointmentId}" />
					<f:param name="doctorId" value="${appointment.doctorId}" />
				</f:url>



				<f:if test="${appointment.isActive}">

					<tr class="appId">
						<td class="appIdData">${appointment.appointmentId}</td>
						<td>${appointment.patient.firstName}</td>
						<td>${appointment.doctor.staff.fullName}</td>
						<td>${appointment.specialization.specializationName}</td>
						<td>${appointment.appointmentDate}</td>
						<td>${appointment.tokenNumber}</td>
						<%-- <td><button class="btn btn-dark bg-gradient"
								onclick="window.location.href='${updatelink}'; return false;">Update</button></td> --%>
						<td><button class="btn btn-dark bg-gradient deleteBtn"
								onclick="getDetails(${appointment.appointmentId})">Delete</button></td>
						<f:choose>
							<f:when test="${isBillPresent}">
								<td><button class="btn btn-dark bg-gradient"
										onclick="window.location.href='${checkoutLink}'; return false;">View</button></td>
							</f:when>
							<f:otherwise>
								<td><button class="btn btn-dark bg-gradient"
										onclick="window.location.href='${checkoutLink}'; return false;">CheckOut</button></td>
							</f:otherwise>
						</f:choose>
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

	var appId = 0;
	function getDetails(appointmentId){
		console.log(appointmentId);
		appId = appointmentId;
		}

		
	$(document).ready(function(){

		window.history.pushState(null, "", window.location.href);        

	    window.onpopstate = function() {

	    window.history.pushState(null, "", window.location.href);

	    };

		/* var d = new Date();
		var strDate = d.getFullYear() + "-" + d.getMonth()+1 + "-" + d.getDate();
		console.log(strDate);
		$('#filterDate').val(strDate); */

		//deleting

		var deleteUrlJs = '';
		
		$('.deleteBtn').click(function(){
			console.log("check");
			console.log("AppID " + appId);
			console.log('"'+appId+ '"')
			if(window.confirm('Do you want to cancel this appointment?')) {
				<f:url var="deletelink" value="/appointment/cancel">
					<f:param name="appointmentId" value=""/>
				</f:url>
				window.location.href='${deletelink}'+appId;
		    }
			});
		})
	</script>
</body>
</html>