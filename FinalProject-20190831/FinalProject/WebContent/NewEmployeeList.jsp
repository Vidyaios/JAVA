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
  width: 100%;
  font-size: 18px;
  padding: 11px;
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
    <input type="text" name="searchList" placeholder="Search.."/>
    <input type="submit" value="Search"/>
        <c:forEach var="eList" items="${requestScope.eList}">
		    <ul id="myMenu">
		      <li><c:set value="${eList.username}" var="names"></c:set>  </li>
		    </ul>
        </c:forEach>
          </div>
</div>
        
        </form>

</div>
</div>

<script >
 
 
    function menuAutoSearch(){ 
          var description ='${eList.username}';
          alert("value" +description);
        $(document).ready(function() {
            description = description.split(":");
            $("#name").autocomplete(description);
        }
         );
    }
</script>
<script>
function myFunction() {
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById("mySearch");
  filter = input.value.toUpperCase();
  ul = document.getElementById("myMenu");
  li = ul.getElementsByTagName("li");
  
  <c:forEach var="eList" items="${requestScope.eList}">
  var test = '<c:out value='${eList.username}'/>';    
  alert("test length " +test);
</c:forEach>

  alert("li length " +li.length);
  for (i = 0; i < li.length; i++) {
    a = li[i].getElementsByTagName("a")[0];
    alert("a value " +a);
    txtValue = a.textContent || a.innerText;
    alert("txtValue value " +txtValue);
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>

</body>
</html>