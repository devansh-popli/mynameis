<%@page import="com.employee.Dao.employeedao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
#form{
	display:flex;
	flex-direction:column;
}
#head{
margin:20px 0px;
display:flex;
}
#logout{
margin-left:400px;
margin-right:20px;
}

</style>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
</head>
<body>
<%
if(session.getAttribute("username")==null)
{
	response.sendRedirect("login.jsp");
}
%>
<div class="container">
<div id="head">
<h2>Add Employees</h2>
<div id="button">
<a id="logout" href="logout" class="btn btn-info">Logout</a>
<a id="view" href="Employee" class="btn btn-info">View Employees</a>
</div>
</div>
</div>
	<form action="update" class="container" id="form">
		<div class="mb-3">
			<label for="EmpName">Name</label> <input
				class="form-control" type="text" id="EmpName" name="EmpName"
				placeholder="Enter employee Name">
		</div>
		<div class="mb-3">
			<label for="EmpLocation">Location</label> <input
				class="form-control" type="text" id="EmpLocation" name="EmpLocation"
				placeholder="Enter your Location">
		</div>
		<div class="mb-3">
			<label for="EmpEmail">Email</label> <input class="form-control"
				type="email" id="EmpEmail" name="EmpEmail" placeholder="Valid Email id">
		</div>
		<div class="mb-3">
			<label for="EmpDOB">Date of Birth</label> <input class="form-control"
				type="date" id="EmpDOB" name="EmpDOB">
		</div>
		<input type="submit" style="width:20%; margin:auto;" class="btn btn-primary " value="Submit">
	</form>
</body>
</html>