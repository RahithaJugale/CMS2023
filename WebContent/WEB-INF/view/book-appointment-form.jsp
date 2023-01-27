<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Appointment</title>
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
	<%@page import="com.faith.dto.DoctorDTO"%>
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
				<a href="<%=request.getContextPath()%>/patient/list"><img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrteWa5kwgakYsbtnNHUsE_oWAoIt4F-ONhg&usqp=CAU"
					alt="back" style="width: 20px; height: 20px"></a>
			</div>
			<div class="col">
				<h2 class="p-3">Appointment Form</h2>
			</div>
		</div>
		<f:form action="save" modelAttribute="appointment" method="post"
			id="appointmentForm">
			<f:hidden path="appointmentId" />
			<f:hidden path="patientId" />
			<%-- <div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Appointment ID</label>
				</div>
				<div class=col-4>
					<f:input path="appointmentId" class="form-control" type="number"
						disabled="true" required="true" />
				</div>
			</div>--%>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Patient ID</label>
				</div>
				<div class=col-4>
					<f:input path="patientId" class="form-control" type="number"
						disabled="true" required="true" />
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Specialization</label>
				</div>
				<div class=col-4>
					<f:select path="specializationId" class="form-control"
						required="true" id="splId">
						<f:option value="0" label="Select Specialization..."
							selected="true" disabled="true" />
						<c:forEach var="specialization" items="${specializations}">
							<f:option value="${specialization.specializationId}"
								label="${specialization.specializationName}" />
						</c:forEach>
					</f:select>
				</div>
			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Doctor Name</label>
				</div>
				<div class=col-4>
					<f:select path="doctorId" class="form-control" required="true"
						id="docSelect">
						<f:option value="" label="Select Doctor..." selected="true"
							disabled="true" />
						<%-- <c:forEach var="doctor" items="${doctors}">
								<f:option value="${doctor.doctorId}" label="${doctor.fullName}" />
						</c:forEach> --%>
					</f:select>
				</div>

			</div>
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">Appointment Date</label>
				</div>
				<div class=col-4>
					<f:input path="appointmentDate" class="form-control" type="date"
						required="true" id="appointmentDate" />
				</div>
				<div class="col-2">
					<button type="button" class="btn btn-dark bg-gradient"
						id="availability">Check Availability</button>

				</div>
				<div class="col-4" style="display: none" id="availabilityInfo">
					<p id="availabilityInfoP"></p>
				</div>
			</div>

			<div class="row pt-3">
				<div class="col-6 m-auto">
					<button class="btn btn-dark bg-gradient" type="reset" id="resetBtn">Reset</button>
					<button class="btn btn-dark bg-gradient" id="submitBtn"
						type="submit" disabled>Submit</button>
				</div>
			</div>

		</f:form>
	</div>
	<script>
		$(document).ready(function(){
			
			window.history.pushState(null, "", window.location.href);        

		    window.onpopstate = function() {

		    window.history.pushState(null, "", window.location.href);

		    };

			//to restrict past dates
			var today = new Date();
			var today1 = new Date();
			var max = today1.setDate(today1.getDate() + 7);
		    var minDate = today.toISOString().substring(0,10);
		    var maxDate = (new Date(max)).toISOString().substring(0,10);
			$('#appointmentDate').attr('min', minDate); 
			$('#appointmentDate').attr('max', maxDate); 
			console.log(maxDate);

			var canSubmit = false;

			//storing doctor DTO list in js object
			var docArr = [];
			<c:forEach var="doctor" items="${doctors}">

			var newObj = { doctorId : ${doctor.doctorId},
						   specializationId: ${doctor.specializationId},
						   fullName: '${doctor.fullName}'
			};
			 
			 console.log(newObj);
			 docArr.push(newObj);
			</c:forEach>
			console.log(docArr);

			//storing all appointments in an js object
			
			var appArr = [];
			<c:forEach var="appoint" items="${allAppointments}">
			console.log(${appoint.appointmentId});
			console.log(${appoint.doctorId});
			console.log('${appoint.appointmentDate}');
			var newObj1 = { appointmentId : ${appoint.appointmentId},
					doctorId: ${appoint.doctorId},
					appointmentDate: '${appoint.appointmentDate}' 
			};
			 
			 console.log(newObj1);
			 appArr.push(newObj1); 
			</c:forEach>
			console.log(appArr);

			var appDocId = ${appointment.doctorId}
			
			console.log(appDocId);

			var splId = $('#splId').find(":selected").val();
			
			if(splId > 0 ){

				
				
			var docId = 1;
			$('#docSelect').html('');
	        $('#docSelect').append('<option value="" label="Select Doctor..." disabled="true" />');
	        for(var i = 0; i<docArr.length;i++){
		        if(appDocId == docArr[i].doctorId){
		        	$('#docSelect').append('<option value="' + docArr[i].doctorId + '" selected="true">' + docArr[i].fullName + '</option>');
		        	continue;
			        }
				if(docArr[i].specializationId == splId){
					$('#docSelect').append('<option value="' + docArr[i].doctorId + '">' + docArr[i].fullName + '</option>');
					}
		        }
			};
			
			//dynamically populate doctor list
			$('#splId').click(function(){

				$('#availabilityInfo').hide();

				var splId = $('#splId').find(":selected").val();

				$('#docSelect').html('');
		        $('#docSelect').append('<option value="" label="Select Doctor..." selected="true" disabled="true" />');

		        for(var i = 0; i<docArr.length;i++){
					if(docArr[i].specializationId == splId){
						$('#docSelect').append('<option value="' + docArr[i].doctorId + '">' + docArr[i].fullName + '</option>');
						}
			        }
				});
				
			$('#availability').click(function(){
				var docSel = $('#docSelect').find(":selected").val();
				var appDate = $('#appointmentDate').val();
				var tokenCount = 0;
				for(var i = 0; i<appArr.length;i++){
					if((docSel == appArr[i].doctorId) && (appDate == appArr[i].appointmentDate)){
						tokenCount += 1;
						}
					}
				console.log("token count "+tokenCount);
				if(tokenCount < 30){
					
					$('#availabilityInfoP').css("color", "green");
					$('#availabilityInfoP').html('Available');
					$('#availabilityInfo').show();
					canSubmit = true;
					
				}else{
					$('#availabilityInfoP').css("color", "red");
					$('#availabilityInfoP').html('Unavailable');
					$('#availabilityInfo').show();
					canSubmit = false;
				}
				if(canSubmit == true){
					$("#submitBtn").removeAttr("disabled");
					}else{
						$("#submitBtn").attr("disabled", true);
						}

					
				});

			$('#resetBtn').click(function(){
				canSubmit = false;
				$('#availabilityInfo').hide();
				if(canSubmit == true){
					$("#submitBtn").removeAttr("disabled");
					}else{
						$("#submitBtn").attr("disabled", true);
						}
				});

			$('#docSelect').click(function(){
				$('#availabilityInfo').hide();
				});

			$('#appointmentDate').click(function(){
				$('#availabilityInfo').hide();
				});

			$('#appointmentForm').change(function() {
				canSubmit = false;
				console.log("Changing");
				console.log(canSubmit);
				if(canSubmit == true){
					$("#submitBtn").removeAttr("disabled");
					}else{
						$("#submitBtn").attr("disabled", true);
						}
			});
			})
			
			
	</script>

</body>
</html>