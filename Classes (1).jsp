<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<p><img alt="" src="pic.jpg"/></p>
<p style="text-align:center;font-weight:bold;background-color:yellow">
		<a href="login">Admin Home   </a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="showAll">Students</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="addNewf">Faculty</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="addNewS">Class-Faculty-Mapping</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="/">Logout</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
	</p>
	<div class="row">
        <div class="col-md-3"  style="border-style: solid;">
            <form name="f1" method="post" action="showall">
             <label for="classname">Class Name :</label>
             <input type="text" name="classname" id="classname" />
	         <br><br>
	         <input type="Submit" value="Add Class" />
            </form>
        </div>
        <div class="col-md-9"  style="border-style: solid;">
            <table width="100%" border="1"  style="color:orange">
            <tr>
            <th>Class ID</th>
            <th>ClassName</th>
            </tr>
            <c:forEach var="classinfo" items="${clsAll }">
            <tr>
            <td>${classinfo.classId }</td>
            <td>${classinfo.className }</td>
            </tr>
            </c:forEach>
            </table>
        </div>
       
    </div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>