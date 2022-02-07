<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="bg-success">
<img src="pic.jpg" class="img-fluid" alt="..."/>
<div style="text-align:center">
<form name="frm1" method="post" action="login" >
<div style="background-color:blue" class="border">
    <label for="username">Username / MailID</label>&nbsp;&nbsp;&nbsp;
	<input type="text" name="username" id="username" placeholder="Type your username..."/>
	<br><br>
	<label for="password">Password</label>&nbsp;&nbsp;&nbsp;
	<input type="text" name="password" id="password" placeholder="Type your password..."/>
	<br><br>
	<label for="usertype">User Type</label>&nbsp;&nbsp;&nbsp;
	<select type="select" >
    <option value="1">Admin</option>
    <option value="2">Faculty</option>
    <option value="3">Student</option>
    </select><br><br>
	<input type="submit" value="Login"/>
	<input type="reset" value="Reset"/>
	</div>
	<h3 style="font-style:italic;color:red">${msg }</h3>
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>