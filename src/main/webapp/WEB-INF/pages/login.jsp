<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital@1&display=swap" rel="stylesheet">
 <style type="text/css">
    <%@include file="/WEB-INF/css/login.css" %></style>
<style>
body{
font-family: 'Roboto', sans-serif;
}
</style>
<body>
<%
if(session.getAttribute("wrongpass")!=null)
	{
	%>
	<script>
alert("Wrong Username or Password");
	</script>
	<% 
	}
	%>
<h3 id="heading">Login</h3>
<form action="employees" method="post" class="container">
<div class="item">
Username:
<input type="text" name="username">
</div>
<div class="item">
Password:
<input type="password" name="password">
</div>
<div class="item">
<a href="">Forgotten your password?</a>
</div>
<div class="item" id="btn">
<input type="submit" value="login>>">
</div>
</form>
</body>
</html>