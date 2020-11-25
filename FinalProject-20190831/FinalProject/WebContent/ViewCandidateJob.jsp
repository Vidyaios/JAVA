<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="jView" class="com.mvc.bean.Job" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>View Job</title>
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
    <a href="CandidateServlet" class="w3-bar-item w3-button w3-padding-large">JOBS</a>
	<div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">USER PROFILE <i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        	<a href="ViewProfileServlet" class="w3-bar-item w3-button">View Profile</a>
        	<a href="EditProfileServlet" class="w3-bar-item w3-button">Edit Profile</a>
      </div>
    </div>    <div class="w3-dropdown-hover w3-hide-small">
      <button class="w3-padding-large w3-button" title="More">USER RESUME <i class="fa fa-caret-down"></i></button>     
      <div class="w3-dropdown-content w3-bar-block w3-card-4">
        <a href="CreateResumeServlet" class="w3-bar-item w3-button">Create/Edit Resume</a>
        <a href="ViewResumeServlet" class="w3-bar-item w3-button">View Resume</a>
        <a href="DeleteResumeServlet" class="w3-bar-item w3-button">Delete Resume</a>
      </div>
    </div>
    <a href="LogoutServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
    </div>
  </div>
</div>

<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32" id="projects">
  <form name="form" action="ViewJobServlet" method="post">
  <h2 style="text-align: center;">View Job</h2>
  <table>
	<tr><td><h3>Job Title 			: ${jView.jobTitle}</h3></td></tr>
	<tr><td><h3>Job Description 	: ${jView.description}</h3></td></tr>
	<tr><td><h3>Salary 				: ${jView.salary}</h3></td></tr>
	<tr><td><h3>Job Type 			: ${jView.jobType}</h3></td></tr>
	<tr><td><h3>Required Experience : ${jView.experience}</h3></td></tr>
	<tr><td><h3>Skills 				: ${jView.jSkills}</h3></td></tr>
	<tr><td><h3>Company Name 		: ${jView.companyName}</h3></td></tr>
	<tr><td><h3>Company Description : ${jView.compDesc}</h3></td></tr>
	<tr><td><h3>Job Location 		: ${jView.city}</h3></td></tr>
	<tr><td><h3>Role 				: ${jView.jobRole}</h3></td></tr>
	<tr><td><h3>Industry Type 		: ${jView.jIndustryType}</h3></td></tr>
	<tr><td><h3>Functional Area 	: ${jView.jFuncArea}</h3></td></tr>
	<tr><td><h3>Qualification 		: ${jView.jEducation}</h3></td></tr>
	<tr><td><h3>Contact Person 		: ${jView.jContactPerson}</h3></td></tr>
	<tr><td><h3>Job Creation Date 	: ${jView.creationDate}</h3></td></tr>
	<tr><td><h3>Job End Date 		: ${jView.endDate}</h3></td></tr>
	</table>
  </form>
 </div>
</div>
</body>
</html>

