<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="jEdit" class="com.mvc.dao.DAOViewJob" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Edit Job</title>

<script>
	function myFunction() {
	  var x = document.getElementById("navDemo");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	  }
	}	
	
	function validate() { 
		 var title = document.form.title.value;
		 var jdesc = document.form.jdesc.value;
		 var salary = document.form.salary.value; 
		 var jType = document.form.jType.value;
		 var skills= document.form.skills.value;
		 var cName= document.form.cName.value;
		 var cDesc= document.form.cDesc.value;
		 var city= document.form.city.value;
		 var jCDate= document.form.jCDate.value;
		 var jEDate= document.form.jEDate.value;
		 var jExp= document.form.jExp.value;
		 
		 if (title==null || title=="") { 
			 alert("Job title can't be blank"); 
			 return false; 
		 } else if (jdesc==null || jdesc=="") { 
			 alert("Job Description can't be blank"); 
			 return false; 
		 } else if (jType==null || jType=="") { 
			 alert("Job Type can't be blank"); 
			 return false; 
		 } else if (jExp==null || jExp=="") { 
			 alert("Experience can't be blank"); 
			 return false; 
		 } else if (skills==null || skills=="") { 
			 alert("Skills can't be blank"); 
			 return false; 
		 } else if (cName==null || cName=="") { 
			 alert("Company name can't be blank"); 
			 return false; 
		 } else if (cDesc==null || cDesc=="") { 
			 alert("Company Description can't be blank"); 
			 return false; 
		 } else if (city==null || city=="") { 
			 alert("Company location can't be blank"); 
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
    <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hide-small">EMPLOYEE LIST</a>
    <a href="LogoutServlet" class="w3-bar-item w3-button w3-padding-large w3-hide-small">LOGOUT</a>
    </div>
  </div>
</div>

<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32" id="projects">
  <h2 style="text-align: center;">Edit Job</h2>
	  <form name="form" action="EditJobServlet" method="post" onsubmit="return validate()">
		<table>
			 <tr><td>Job Title<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="title" placeholder="Enter the job title" size="50" value = '<%=jEdit.j_title%>'/></td></tr>
			 <tr><td>Job Description<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="jdesc" placeholder="Enter the job Description" size="50" value = '<%=jEdit.j_desc%>'/></td></tr>
			 <tr><td>Salary &nbsp;</td><td><input type="text" name="salary" placeholder="Enter job salary" size="50" value = '<%=jEdit.j_salary%>'/></td></tr>
			 <tr><td>Required Experience<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="jExp" placeholder="Enter required experience for the job" size="50" value = '<%=jEdit.j_experience %>'/></td></tr>
			 <tr><td>Job Type<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="jType" placeholder="Enter job type (Full-time,Part-time,Freelance,Intern)" size="50" value = '<%=jEdit.j_type %>'/></td></tr>
			 <tr><td>Skills<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="skills" placeholder="Enter the skills required for the job" size="50" value = '<%=jEdit.j_skills%>'/></td></tr>
			 <tr><td>Company Name<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="cName" placeholder="Enter company name" size="50" value = '<%=jEdit.j_companyName%>'/></td></tr>
			 <tr><td>Company Description<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="cDesc" placeholder="Enter company description" size="50" value = '<%=jEdit.j_companyDesc%>'/></td></tr>
			 <tr><td>City<label style="color:red;">* &nbsp;</label></td><td><input type="text" name="city" placeholder="Enter the city in which the company is located" size="50" value = '<%=jEdit.j_city%>'/></td></tr>
			 <tr><td>Role &nbsp;</td><td><input type="text" name="role" placeholder="Enter the role" size="50" value = '<%=jEdit.j_role%>'/></td></tr>
			 <tr><td>Industry Type &nbsp;</td><td><input type="text" name="jIndusType" placeholder="Enter the industry type" size="50" value = '<%=jEdit.j_industryType%>'/></td></tr>
			 <tr><td>Functional Area &nbsp;</td><td><input type="text" name="jFuncArea" placeholder="Enter the functional area" size="50" value = '<%=jEdit.j_FuncArea%>'/></td></tr>
			 <tr><td>Required Qualification &nbsp;</td><td><input type="text" name="jEdu" placeholder="Enter the required qualification for the job" size="50" value = '<%=jEdit.j_education%>'/></td></tr>
			 <tr><td>Contact Person &nbsp;</td><td><input type="text" name="jCPerson" placeholder="Enter the contact person" size="50" value = '<%=jEdit.j_contactPerson%>'/></td></tr>
			 <tr><td>Job Creation Date &nbsp;</td><td><input type="date" name="jCDate" placeholder="Select the job creation date" size="50" value = '<%=jEdit.j_creationDate%>'/></td></tr>
			 <tr><td>Job End Date &nbsp;</td><td><input type="date" name="jEDate" placeholder="Select the job end date" size="50" value = '<%=jEdit.j_endDate%>'/></td></tr>
			 <tr><td><input type="submit" value="SUBMIT" size="50"></td></tr>
		</table>
	</form>
	</div>
</div>
</body>
</html>