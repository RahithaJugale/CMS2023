<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient form</title>
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
				<a href="<%=request.getContextPath()%>/patient/list"><img
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrteWa5kwgakYsbtnNHUsE_oWAoIt4F-ONhg&usqp=CAU"
					alt="back" style="width: 20px; height: 20px"></a>
			</div>
			<div class="col">
				<h2 class="p-3">Patient Form</h2>
			</div>
		</div>

		<f:form action="save" modelAttribute="patient" method="post">
			<f:hidden path="patientId" />
			<!--<f:hidden path="createdAt"/>
			<f:hidden path="isActive"/>-->
			<div class="row pt-4">
				<div class=col-2>
					<label class="form-label">First Name*</label>
				</div>
				<div class=col-4>
					<f:input path="firstName" class="form-control" id="firstName"
						type="text" placeholder="Enter First Name" required="true"
						pattern="[A-Za-z ]{3,15}" disabled="true"/>
				</div>
				<div class="col-6">
					<p class="text-danger" id="firstNameError"></p>
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Last Name*</label>
				</div>
				<div class=col-4>
					<f:input path="lastName" class="form-control" id="lastName"
						type="text" placeholder="Enter Last Name" required="true"
						pattern="[A-Za-z ]{3,15}" disabled="true"/>
				</div>
				<div class="col-6">
					<p class="text-danger" id="lastNameError"></p>
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Date Of Birth*</label>
				</div>
				<div class=col-4>
					<f:input path="dateOfBirth" class="form-control" id="dob"
						type="date" min="1930-01-01" required="true" disabled="true"/>
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Gender*</label>
				</div>
				<div class=col-4>
					<div class="row">
						<div class="col ms-3 form-check">
							<f:radiobutton path="gender" class="form-check-input"
								value="Male" required="true" disabled="true"/>
							<label class="form-check-label" for="Male">Male</label>
						</div>
						<div class="col form-check">
							<f:radiobutton path="gender" class="form-check-input"
								value="Female" required="true" disabled="true"/>
							<label class="form-check-label" for="Female">Female</label>
						</div>
					</div>
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Blood Group*</label>
				</div>
				<div class=col-4>
					<f:select path="bloodGroup" class="form-control" id="bldGrp"
						required="true" disabled="true">
						<f:option value="" label="Select Blood Group..." selected="true"
							disabled="true" />
						<f:option value="O+" label="O+" />
						<f:option value="O-" label="O-" />
						<f:option value="A+" label="A+" />
						<f:option value="A-" label="A-" />
						<f:option value="B+" label="B+" />
						<f:option value="B-" label="B-" />
						<f:option value="AB+" label="AB+" />
						<f:option value="AB-" label="AB-" />
					</f:select>
				</div>
				<div class="col-6">
					<p class="text-danger" id="bloodGroupError"></p>
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Phone Number*</label>
				</div>
				<div class=col-4>
					<f:input path="phoneNumber" class="form-control" type="text"
						pattern="[0-9]{10,10}" placeholder="Enter Phone Number"
						required="true" />
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Email*</label>
				</div>
				<div class=col-4>
					<f:input path="email" class="form-control" type="email"
						placeholder="Enter Email ID" required="true" />
				</div>
			</div>
			<div class="row pt-2">
				<div class=col-2>
					<label class="form-label">Address*</label>
				</div>
				<div class=col-4>
					<f:textarea path="address" class="form-control"
						placeholder="Enter Address" rows="2" cols="20" required="true"
						pattern="[A-Za-z0-9'\.\-\s\,]{3,70}" />
				</div>
				<div class="col-6">
					<p class="text-danger" id="addressError"></p>
				</div>
			</div>
			<div class="row pt-3">
				<div class="col-6 m-auto">

					<button class="btn btn-dark bg-gradient" id="resetBtn" type="reset">Reset</button>
					<button class="btn btn-dark bg-gradient" id="submitBtn"
						type="submit">Submit</button>
				</div>
			</div>

		</f:form>
	</div>
	<script>
		$(document).ready(function() {
			
			window.history.pushState(null, "", window.location.href);        

		    window.onpopstate = function() {

		    window.history.pushState(null, "", window.location.href);

		    };

			//to restrict date values
			var today = new Date();
			maxDate = today.toISOString().substring(0, 10);
			$('#dob').attr('max', maxDate);

			/* $('#submitBtn').click(function(){

				var bloodGroup = $('#bldGrp').val();
				if(bloodGroup == 0){
					$('#bloodGroupError').html('Please select your Blood group');
					} else{
						window.location.href='/save';
						}
				
				});

			$('#bldGrp').focus(function(){
				$('#bloodGroupError').html('');
				}); */

		})
	</script>
</body>
</html>