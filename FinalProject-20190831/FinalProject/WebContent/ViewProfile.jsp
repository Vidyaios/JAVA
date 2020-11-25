<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="profile" class="com.mvc.bean.Register" scope="request"/>
    <jsp:useBean id="uprofile" class="com.mvc.dao.DAOViewProfile" scope="request"/>
    <jsp:useBean id="type" class="com.mvc.dao.DAOLogin" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>View User Profile</title>
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
<script>
var node;
if(type.userType.match("/Candidate")) {
    node = document.getElementById('if-part');
} else {
    node = document.getElementById('else-part');
}
node.style.visibility = 'visible';
</script>
<style type="text/css">
body {
  font-family: Arial, Helvetica, sans-serif;
}</style>
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
    </div>    
	<div class="w3-dropdown-hover w3-hide-small">
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
  <div class="w3-container w3-padding-32">
  <h2 style="text-align: center;">View User Profile</h2>
		<form name="form" action="ViewProfileServlet" method="post">
			<h3>User Name : ${profile.username}</h3>
			<h3>Password  : ${profile.password}</h3>
			<h3>Email 	  : ${profile.email}</h3>
			<h3>Type 	  : ${profile.type}</h3>
		</form>
  </div>
</div>
</body>
</html>