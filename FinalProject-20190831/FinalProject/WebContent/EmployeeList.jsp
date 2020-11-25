<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.mvc.bean.Register"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

/* Create a column layout with Flexbox */
.row {
  display: flex;
}

/* Left column (menu) */
.left {
  flex: 100%;
  padding: 15px 0;
}

.left h2 {
  padding-left: 8px;
}

/* Right column (page content) */
.right {
  flex: 0%;
  padding: 15px;
}

/* Style the search box */
#mySearch {
  width: 85%;
  font-size: 18px;
  padding: 4px;
  border: 1px solid #ddd;
}

/* Style the navigation menu inside the left column */
#myMenu {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

#myMenu li a {
  padding: 12px;
  text-decoration: none;
  color: black;
  display: block
}

#myMenu li a:hover {
  background-color: #eee;
}
.button {
     font-size: 20px ;
  text-decoration: none;
  background-color: #EEEEEE;
  color: #333333;
  padding: 12px 50px 12px 50px;
  border-top: 1px solid #CCCCCC;
  border-right: 1px solid #333333;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #CCCCCC;
  margin: 250px 50px 0px 0px;
  text-align: center;
}
p {
font-size: 14px;
color: grey;
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
  <div class="w3-container w3-padding-32" id="projects">
  <form name="form" action="EmployeeListServlet" method="post">
  <h2 style="text-align: center;">Employee List</h2>
<div class="row">
  <div class="left"> 
	    <input type="text" name="empname" id="mySearch" placeholder="Search.."/>
	    <input type="submit" value="Search"/>
	        <c:forEach var="eList" items="${requestScope.eList}">
			    <ul id="myMenu">
			      <li><a href="ViewResCompanyServlet?userid=${eList.uID}">${eList.username}</a></li>
			    </ul>
	        </c:forEach>
  </div>
</div>
</form>
<p><b>NOTE :<br>Click Employee List tab in the menu to display all the employees.<br>Click the employee name to view the resume of the employee.</b></p>
</div>
</div>
</body>
</html>