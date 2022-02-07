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
		<a href="addclass">Classes</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="addNewf">Faculty</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="removeEmp">Class-Faculty-Mapping</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
		<a href="/">Logout</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
	</p>
	<div class="row">
        <div class="col-md-3"  style="border-style: solid;">
            <form name="f1" method="post" action="addNewSprocess" style="text-align:center; background-color:blue">
             <input type="text" name="txtrollno" placeholder="Rollno" />
	         <br><br>
	         <input type="text" name="txtstdName" placeholder="StdName" />
             <br /><br />
             <input type="text" name="txtgender" placeholder="Gender" />
             <br /><br />
             <input type="text" name="txtaddress" placeholder="Address" />
             <br /><br />
             <input type="text" name="txtlocation" placeholder="Location" />
             <br /><br />
             <input type="text" name="txtphone" placeholder="Phone" />
             <br /><br />
             <input type="text" name="txtemail" placeholder="Email" />
             <br /><br />  
             <input type="text" name="txtpassword" placeholder="Password" />
             <br /><br /> 
             <input type="text" name="txtclassId" placeholder="ClassID" />
             <br /><br />    
	         <input type="Submit" value="Add Student" />
            </form>
        </div>
        <div class="col-md-9"  style="border-style: solid;">
        <form name="frm1" style="margin:0 auto;width:500px">
<table width=100% class="table table-success table-striped">
<tr style="border-style:solid;text-align:left">
	<th>Rollno</th> <th>StdName</th> <th>Gender</th> <th>Address</th> <th>Location</th> <th>Phone</th> <th>Email</th> <th>Password</th> <th>ClassID</th>
</tr>
<c:forEach var="StudentReg" items="${elist}">
<tr>
	<td>${StudentReg.rollno }</td> <td>${StudentReg.stdName }</td> <td>${StudentReg.gender }</td> 
	<td>${StudentReg.address }</td> <td>${StudentReg.location }</td> <td>${StudentReg.phone }</td>
	<td>${StudentReg.email }</td> <td>${StudentReg.Password }</td>
</tr>
</c:forEach>
</table>
</form>
 </div>
       
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>