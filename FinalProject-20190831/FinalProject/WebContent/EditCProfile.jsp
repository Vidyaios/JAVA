<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="cprofile" class="com.mvc.dao.DAOViewCProfile" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Edit Employer Profile</title>
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
    </div>	<div class="w3-dropdown-hover w3-hide-small">
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

<!-- Page Content -->
<div class="w3-content w3-padding" style="max-width:1564px">

<!-- Project Section -->
<div class="w3-container w3-padding-32">
		<h2 style="text-align: center;">Edit User Profile</h2>
		<form name="form" action="EditCProfileServlet" method="post" onsubmit="return validate()">
			<table>
				 <tr><td>Email ID &nbsp;</td><td><input type="email" name="email" placeholder="Email ID" value='<%=cprofile.c_email%>'/></td></tr>
				 <tr><td>Password&nbsp;</td><td><input type="password" name="password" placeholder="Password" value='<%=cprofile.c_password%>'/></td></tr>
				 <tr><td>Confirm Password&nbsp;</td><td><input type="password" name="conpassword" placeholder="Confirm Password" value='<%=cprofile.c_password%>'/></td></tr>
				 <tr><td>Company Name&nbsp;</td><td><input type="text" name="cname" placeholder="Company Name" value='<%=cprofile.c_companyName%>'/></td></tr>
				 <tr><td>Industry Type&nbsp;</td><td><input type="text" name="indusType" placeholder="Industry Type" value='<%=cprofile.c_industryType%>'/></td></tr>
				 <tr><td>Organization Type&nbsp;</td><td><select name = "type" value='<%=cprofile.c_orgType%>'>
					  <option value="Company">Company</option>
					  <option value="Consultant">Consultant</option>
					  <option value="Candidate">Candidate</option>
				 </select></td></tr>
				 <tr><td>Contact Person Name&nbsp;</td><td><input type="text" name="pname" placeholder="Contact Person Name" value='<%=cprofile.c_contactPerson%>'/></td></tr>
				 <tr><td>Designation&nbsp;</td><td><input type="text" name="desi" placeholder="Designation" value='<%=cprofile.c_designation%>'/></td></tr>
				 <tr><td>Office Address&nbsp;</td><td><input type="text" name="addr" placeholder="Office Address" value='<%=cprofile.c_address%>'/></td></tr>
				 <tr><td>Country&nbsp;</td><td><input type="text" name="country" placeholder="Country" value='<%=cprofile.c_country%>'/></td></tr>
				 <tr><td>State&nbsp;</td><td><input type="text" name="state" placeholder="State" value='<%=cprofile.c_state%>'/></td></tr>
				 <tr><td>City &nbsp;</td><td><input type="text" name="city" placeholder="City" value='<%=cprofile.c_city%>'/></td></tr>
				 <tr><td> Pincode&nbsp;</td><td><input type="text" name="pincode" placeholder="Pincode" value='<%=cprofile.c_pincode%>'/></td></tr>
				 <tr><td>Mobile Number&nbsp;</td><td><input type="text" name="mnumber" placeholder="Mobile Number" value='<%=cprofile.c_mnumber%>'/></td></tr>
				 <tr><td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")%></span></td></tr>
				 <tr><td><input type="submit" value="Update"></input></td></tr>
			 </table>

		</form>
		</div>
</div>
</body>
</html>

