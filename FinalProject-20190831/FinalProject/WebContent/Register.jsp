<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>User Registeration</title>
<script> 
function validate()
{ 
 var username = document.form.username.value;
 var password = document.form.password.value;
 var conpassword = document.form.conpassword.value; 
 var email = document.form.email.value;
 var type= document.form.type.value;
 
 if (username==null || username=="")
 { 
 alert("Username can't be blank"); 
 return false; 
 }
 else if(password.length<6)
 { 
 alert("Password must be at least 6 characters long."); 
 return false; 
 } 
 else if (password!=conpassword)
 { 
 alert("Confirm Password should match with the Password"); 
 return false; 
 } 
 else if (email==null || email=="")
 { 
 alert("Email can't be blank"); 
 return false; 
 }
 else if (type==null || type=="")
 { 
 alert("LoginType can't be blank"); 
 return false; 
 }
 } 
</script> 
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}
</style>
</head>
<body>
<div class="w3-top">
  <div class="w3-bar w3-white w3-card">
	  <a href="#" class="w3-bar-item w3-button w3-padding-large"><b>MyJobOnline Placement Agency</b></a>
	  <div class="w3-right w3-hide-small">
		    <a class="w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right" href="javascript:void(0)" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
		    <a href="IntroServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">JOBS</a>	
		    <a href="Login.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">EMPLOYEE LOGIN</a>
		    <a href="CLogin.jsp" class="w3-bar-item w3-button w3-padding-large w3-hide-small">EMPLOYER LOGIN</a>
	  </div>
  </div>
</div>
	<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32" id="projects">
  <h3 style="text-align: center;">Employee Registeration</h3>
	<form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
		<table style="align-content: center;">
		 <tr>
		 <td>User Name&nbsp;</td>
		 <td><input type="text" name="username" /></td>
		 </tr>
		 <tr>
		 <td>Password&nbsp;</td>
		 <td><input type="password" name="password" /></td>
		 </tr>
		 <tr>
		 <td>Confirm Password&nbsp;</td>
		 <td><input type="password" name="conpassword" /></td>
		 </tr>
		 <tr>
		 <td>Email&nbsp;</td>
		 <td><input type="email" name="email" /></td>
		 </tr>
		 <tr>
		 <td>User Type&nbsp;</td>
		 <td>
		 <select name = "type" disabled>
			  <option value="Candidate">Candidate</option>
			  <option value="Company">Company</option>
		 </select>
		 </td>
		 </tr>
		 <tr>
		 <td><%=(request.getAttribute("errMessage") == null) ? ""
		 : request.getAttribute("errMessage")%></td>
		 </tr>
		 <tr>
		 <td></td>
		 <td><input type="submit" value="Register"></input></td>
		 </tr>
		</table>
	</form>
	</div>
	</div>
</body>
</html>