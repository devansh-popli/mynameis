<%@page import="com.employee.Dao.employeedao,com.employee.Model.EmployeeEntity,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style>
td{
text-align:center;
}
#right{
display:flex;
width:400px;
float:right;
}
#welcome{
margin-right:30px;
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
<div id="right">
<h3 id="welcome">Welcome ${username}</h3>
<a href="logout" class="btn btn-info">Log Out</a>
</div>
<h2 style="color:RGB(68, 184, 172);text-align:center;margin:20px;">Employee Listing</h2>
<table class="table table-striped table-hover">
<tr class="table-info">
           <td scope="col">Employee Code</td>
            <td scope="col">Employee Name</td>
            <td scope="col">Location</td>
            <td scope="col">Email</td>
            <td scope="col">Date of Birth</td>
            <td scope="col">Action</td>
        </tr>
      
    <c:forEach items="${employeelist}" var="employee" varStatus="tagStatus">
        <tr>
            <td>${employee.getEmployee_Code()}</td>
            <td>${employee.getEmployee_Name()}</td>
              <td>${employee.getLocation()}</td>
            <td>${employee.getEmail()}</td>
            <td>${employee.getDate_of_Birth()}</td>
            <td><a href="editEmployee?empcode=${employee.getEmployee_Code()}" class="btn btn-info">Edit</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="backHome" class="btn btn-info">Add Data</a>
</div>
</body>
</html>