<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <jsp:useBean id="cprofile" class="com.mvc.bean.CRegister" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Company View Profile</title>
<script>
	function myFunction() {
	  var x = document.getElementById("navDemo");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
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
	<div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="">JOBS <i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="CompanyServlet" class="w3-bar-item w3-button">List Jobs</a>
        <a href="CreateJob.jsp" class="w3-bar-item w3-button">Create Job</a>
      </div>
    </div>	
    <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">USER PROFILE <i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="ViewCprofileServlet" class="w3-bar-item w3-button">View Profile</a>
        <a href="EditCProfileServlet" class="w3-bar-item w3-button">Edit Profile</a>
      </div>
    </div>    
    <a href="EmployeeListServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">EMPLOYEE LIST</a>
    <a href="LogoutServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
    </div>
  </div>
</div>

<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32">
  <h2 style="text-align: center;">View Company Profile</h2>
  			<h3>Email 	  				: ${cprofile.email}</h3>
			<h3>Password  				: ${cprofile.password}</h3>
			<h3>Company Name 			: ${cprofile.companyName}</h3>
			<h3>Industry Type			: ${cprofile.industryType}</h3>
			<h3>Organisation Type		: ${cprofile.orgType}</h3>
			<h3>Contact Person's Name	: ${cprofile.contactPerson}</h3>
			<h3>Designation				: ${cprofile.designation}</h3>
			<h3>Address					: ${cprofile.address}</h3>
			<h3>Country					: ${cprofile.country}</h3>
			<h3>State					: ${cprofile.state}</h3>
			<h3>City					: ${cprofile.city}</h3>
			<h3>Pincode					: ${cprofile.pincode}</h3>
			<h3>Mobile Number			: ${cprofile.mobileNumber}</h3>
  </div>
</div>
</body>
</html>
