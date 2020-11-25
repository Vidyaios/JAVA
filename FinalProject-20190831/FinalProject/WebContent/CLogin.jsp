<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Employer Login</title>
<script> 
		function validate()
		{ 
		 var email = document.form.email.value; 
		 var password = document.form.password.value;
		 
		 if (email==null || email=="")
		 { 
		 alert("Email cannot be blank"); 
		 return false; 
		 }
		 else if(password==null || password=="")
		 { 
		 alert("Password cannot be blank"); 
		 return false; 
		 } 
		}
	</script> 
	<style type="text/css">
		td,tr {
			text-align: center;
		}

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
  <h3 style="text-align: center;">Employer Login</h3> 
  
	<form name="form" action="CLoginServlet" method="post" onsubmit="return validate()">
	<!-- Do not use table to format fields. As a good practice use CSS -->
	<table>
	 <tr >
	 <td style="text-align: left;">Email&nbsp;</td>
	 <td><input type="email" name="email" /></td>
	 </tr>
	 <tr>
	 <td style="text-align: left;">Password&nbsp;</td>
	 <td><input type="password" name="password" /></td>
	 </tr>
	 <tr> 
	 <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
	 : request.getAttribute("errMessage")%></span></td>
	 </tr>
	 <tr>
	 <td></td>
	 <td><input type="submit" value="Login"></input></td>
	 </tr>
	</table>
	</form>
	<p>Are you a new user ? </p>
    <a style="text-align: center;" href="CRegister.jsp">Register Now</a>
    </div>
    </div>
</body>
</html>