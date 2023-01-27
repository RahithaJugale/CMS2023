<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page not found</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>
<h1>404 - Page Not Found</h1>
<a href="<%=request.getContextPath()%>/login">Click here to login again</a>
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