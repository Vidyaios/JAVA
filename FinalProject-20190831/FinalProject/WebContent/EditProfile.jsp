<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="uprofile" class="com.mvc.dao.DAOViewProfile" scope="request"/>
    <jsp:useBean id="profile" class="com.mvc.bean.Register" scope="request"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Edit User Profile</title>
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

<!-- Page Content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32">
		<h2 style="text-align: center;">Edit User Profile</h2>
		<form name="form" action="EditProfileServlet" method="post" onsubmit="return validate()">
		<table>
			 <tr>
			 <td>User Name</td>
			 <td><input type="text" name="username" value = '<%=uprofile.p_username%>' /></td>
			 </tr>
			 <tr>
			 <td>Password</td>
			 <td><input type="text" name="password" value = '<%=uprofile.p_password%>'/></td>
			 </tr>
			 <tr>
			 <td>Confirm Password</td>
			 <td><input type="text" name="password" value = '<%=uprofile.p_password%>'/></td>
			 </tr>
			 <tr>
			 <td>Email</td>
			 <td><input type="email" name="email" value = '<%=uprofile.p_email%>'/></td>
			 </tr>
			 <tr>
			 <td>type</td>
			 <td><input type="text" name="type" value = '<%=uprofile.p_type%>' readonly="readonly"/></td>
			 </tr>
			 <tr> 
			 <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
			 : request.getAttribute("errMessage")%></span></td>
			 </tr>
			 <tr>
			 <td></td>
			 <td style="text-align: center;"><input type="submit" value="Update"></input></td>
			 </tr>
		</table>
		</form>
		</div>
</div>
</body>
</html>