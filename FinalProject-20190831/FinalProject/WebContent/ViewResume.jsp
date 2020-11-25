<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="vResume" class="com.mvc.dao.DAOCreateResume" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>View Resume</title>
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
        <a href="EditProfile.jsp" class="w3-bar-item w3-button">Edit Profile</a>
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
<br>
	
	<!-- ******************************************************************************************************************************************************************************** -->
<!-- Page Container -->
<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32">
<div class="w3-content w3-margin-top" style="max-width:1400px;">

  <!-- The Grid -->
  <div class="w3-row-padding">
  
    <!-- Left Column -->
    <div class="w3-third">
    
      <div class="w3-white w3-text-grey w3-card-4">
        <div class="w3-display-container">
          <img src="http://buira.org/assets/images/shared/default-profile.png" style="width:100%" alt="Profile">
          <div class="w3-display-bottomleft w3-container w3-text-silver">
            <h2><%=vResume.r_name%></h2>
          </div>
        </div>
        <div class="w3-container">
          <p><i class="fa fa-briefcase fa-fw w3-margin-right w3-large w3-text-silver"></i><%=vResume.r_currDesc%></p>
          <p><i class="fa fa-home fa-fw w3-margin-right w3-large w3-text-silver"></i><%=vResume.r_currLocation%></p>
          <p><i class="fa fa-envelope fa-fw w3-margin-right w3-large w3-text-silver"></i><%=vResume.r_email%></p>
          <p><i class="fa fa-phone fa-fw w3-margin-right w3-large w3-text-silver"></i><%=vResume.r_number%></p>
          <hr>

          <p class="w3-large"><b><i class="fa fa-asterisk fa-fw w3-margin-right w3-text-silver"></i>Skills</b></p>
          <p><%=vResume.r_skills%></p>
          <p><%=vResume.r_skills2%></p>
          <p><%=vResume.r_skills3%></p>
          <p><%=vResume.r_skills4%></p>
          <br>
                    
          <p class="w3-large"><b><i class="fa fa-suitcase fa-fw w3-margin-right w3-text-silver"></i>Total Work Experience</b></p>
          <p><%=vResume.r_workFromYear%> year(s) <%=vResume.r_workFromYear%> month(s)</p>
          <br>
          
          <p class="w3-large"><b><i class="fa fa-suitcase fa-fw w3-margin-right w3-text-silver"></i>Expected Annual Salary</b></p>
          <p><%=vResume.r_salaryL%> lakh(s) <%=vResume.r_salaryT%> thousand(s)</p>
          <br>
          
          <p class="w3-large w3-text-theme"><b><i class="fa fa-globe fa-fw w3-margin-right w3-text-silver"></i>Languages</b></p>
          <p><%=vResume.r_lang1%></p>
          <p><%=vResume.r_lang2%></p>
          <p><%=vResume.r_lang3%></p>
          
        </div>
      </div><br>

    <!-- End Left Column -->
    </div>

    <!-- Right Column -->
    <div class="w3-twothird">
    
      <div class="w3-container w3-card w3-white w3-margin-bottom">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-suitcase fa-fw w3-margin-right w3-xxlarge w3-text-gray"></i>Work Experience</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b><%=vResume.r_role%></b></h5>
          <h6 class="w3-text-grey"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=vResume.r_workFromMonth%> <%=vResume.r_workFromYear%> - <%=vResume.r_workToMonth%> <%=vResume.r_workToYear%></h6>
          <p>Company Name : <%=vResume.r_currComp%></p>
          <p>Description : <%=vResume.r_currDesc%></p>
          <p>Industry : <%=vResume.r_indusrty%></p>
          <p>Funcational Area : <%=vResume.r_funcArea%></p>
          <hr>
        </div>
        <div class="w3-container">
          <h5 class="w3-opacity"><b><%=vResume.r_preCompDesc%></b></h5>
          <h6 class="w3-text-grey"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=vResume.r_preFromMonth%> <%=vResume.r_preFromYear%> - <%=vResume.r_preToMonth%> <%=vResume.r_preToYear%></h6>
		  <p>Company Name : <%=vResume.r_preCompany%></p>
        </div>
      </div>

      <div class="w3-container w3-card w3-white">
        <h2 class="w3-text-grey w3-padding-16"><i class="fa fa-certificate fa-fw w3-margin-right w3-xxlarge w3-text-grey"></i>Education</h2>
        <div class="w3-container">
          <h5 class="w3-opacity"><b><%=vResume.r_university%></b></h5>
          <h6 class="w3-text-grey"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=vResume.r_passYear%></h6>
          <p><%=vResume.r_course%></p>
          <hr>
        </div>
        <div class="w3-container">
          <h5 class="w3-opacity"><b><%=vResume.r_prevUniversity%></b></h5>
          <h6 class="w3-text-grey"><i class="fa fa-calendar fa-fw w3-margin-right"></i><%=vResume.r_prePassYear%></h6>
          <p><%=vResume.r_prevDegree%></p>
          <hr>
        </div>
      </div>

    <!-- End Right Column -->
    </div>
    
  <!-- End Grid -->
  </div>
  
  <!-- End Page Container -->
</div>
</div>
</div>
</body>
</html>