<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>MyJobOnline</title>
<style type="text/css">
    * {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 100%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
  padding: 10px 10px;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: left;
  background-color: #f1f1f1;
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
  <h3 style="text-align: center;">Jobs</h3>
  <form name="form" action="IntroServlet" method="post">
  	<c:forEach var="job" items="${requestScope.jobs}">
		  <div class="row">
		    <div class="card">
          			<h3><b>${job.jobTitle}</b></h3>
          			<h4>${job.companyName}</h4>
          			<a href="ViewJobServlet?jid=${job.jobID}">View Job</a>
          		</div>
		    </div>
     </c:forEach>  
  </form>
  </div>
</div>
</body>
</html>

