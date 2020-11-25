<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="userresume" class="com.mvc.dao.DAOCreateResume" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Candidate Delete CV</title>
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
	
	<!-- Page content -->
<div class="w3-content w3-padding" style="max-width:1564px">

  <!-- Project Section -->
  <div class="w3-container w3-padding-32">
  <form name="form" action="CreateResumeServlet" method="post" onsubmit="return validate();">
  <h3>Delete Resume</h3><br>
  <fieldset>
	  <legend style="font-weight:bold;">  &nbsp; Personal Details  &nbsp; </legend>
	  Name<label style="color:red;">* &nbsp;</label> <input type="text" name="name" size="120" placeholder = "Enter your full name" value = '<%=userresume.r_name%>' disabled/><br><br>
	  Email<label style="color:red;">* &nbsp;</label> <input type="email" name="email" size="120" placeholder = "Enter your active email id where recruiters can contact you" value = '<%=userresume.r_email%>' disabled/><br><br>
	  Mobile Number<label style="color:red;">* &nbsp;</label> <input type="text" name="mnumber" size="120" placeholder = "Enter your number where recruiters can contact you" value = '<%=userresume.r_number%>' disabled/> <br><br>
	  Total Work Experience<label style="color:red;">* &nbsp;</label> <select name = "expyear" value = '<%=userresume.r_workexpyear%>' disabled>
	  		  <option disabled="disabled" selected value="" style="color:gray">Year(s)</option>
			  <option value="0">0</option>
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			  <option value="6">6</option>
			  <option value="7">7</option>
			  <option value="8">8</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			  <option value="10+">10+</option>
		 </select>
		<label style="color:#929cad;">Year(s)</label>
		<select name = "expmonth" value = '<%=userresume.r_workexpmon%>' disabled>
		 <option disabled="disabled" selected value="" style="color:gray">Month(s)</option>
			  <option value="0">0</option>
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			  <option value="6">6</option>
			  <option value="7">7</option>
			  <option value="8">8</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			  <option value="11">11</option>
		 </select>
		<label style="color:#929cad;">Month(s)</label><br><br>
		Known Language1<label style="color:red;">* &nbsp;</label> <input type="text" name="lang1" size="120" placeholder = "Enter the known language one" value = '<%=userresume.r_lang1%>' disabled/><br><br>
		Known Language2<label style="color:red;">* &nbsp;</label> <input type="text" name="lang2" size="120" placeholder = "Enter the known language two" value = '<%=userresume.r_lang2%>' disabled/><br><br>
		Known Language3<label style="color:red;">* &nbsp;</label> <input type="text" name="lang3" size="120" placeholder = "Enter the known language three" value = '<%=userresume.r_lang3%>' disabled/><br><br>
  </fieldset><br>
  <fieldset>
	  <legend style="font-weight:bold;">  &nbsp; Employment Details  &nbsp; </legend>
	  Current Designation<label style="color:red;">* &nbsp;</label> <input type="text" name="currDesc" size="120" placeholder = "Your job title" value = '<%=userresume.r_currDesc%>' disabled/><br><br>
	  Current Company<label style="color:red;">* &nbsp;</label><input type="text" name="currComp" size="120" placeholder = "Where you are currently working" value = '<%=userresume.r_currComp%>' disabled/><br><br>
	  Annual Salary<label style="color:red;">* &nbsp;</label> <select name = "annSalLakh" value = '<%=userresume.r_salaryL%>' disabled>
	  		  <option disabled selected value="">Lakh(s)</option>
			  <option value="0">0</option>
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="5">5</option>
			  <option value="6">6</option>
			  <option value="7">7</option>
			  <option value="8">8</option>
			  <option value="9">9</option>
			  <option value="10">10</option>
			  <option value="10+">10+</option>
		 </select>
		<label style="color:#929cad;">Lakh(s)</label>
		<select name = "annSalThousand" value = '<%=userresume.r_salaryT%>' disabled>
		      <option disabled selected value="">Thousand</option>
			  <option value="0">0</option>
			  <option value="10">10</option>
			  <option value="20">20</option>
			  <option value="30">30</option>
			  <option value="40">40</option>
			  <option value="50">50</option>
			  <option value="60">60</option>
			  <option value="70">70</option>
			  <option value="80">80</option>
			  <option value="90">90</option>
		 </select>
		<label style="color:#929cad;">Thousand</label> <br><br>
		Duration<label style="color:red;">* &nbsp;</label> <select name = "workFromYear" value = '<%=userresume.r_workFromYear%>' disabled>
	  		  <option disabled="disabled" selected value="" style="color:gray">Year</option>
			  <option value="Present">Present</option>
			  <option value="2019">2019</option>
			  <option value="2018">2018</option>
			  <option value="2017">2017</option>
			  <option value="2016">2016</option>
			  <option value="2015">2015</option>
			  <option value="2014">2014</option>
			  <option value="2013">2013</option>
			  <option value="2012">2012</option>
			  <option value="2011">2011</option>
			  <option value="2010">2010</option>
			  <option value="2009">2009</option>
		 </select>
		<select name = "workFromMonth" value = '<%=userresume.r_workFromMonth%>' disabled>
		 <option disabled="disabled" selected value="" style="color:gray">Month</option>
			  <option value="Jan">Jan</option>
			  <option value="Feb">Feb</option>
			  <option value="Mar">Mar</option>
			  <option value="Apr">Apr</option>
			  <option value="May">May</option>
			  <option value="Jun">Jun</option>
			  <option value="Jul">Jul</option>
			  <option value="Aug">Aug</option>
			  <option value="Sep">Sep</option>
			  <option value="Oct">Oct</option>
			  <option value="Nov">Nov</option>
			  <option value="Dec">Dec</option>
		 </select>
		<label style="color:#929cad;">to</label>
		<select name = "workToYear" value = '<%=userresume.r_workToYear%>' disabled>
	  		  <option disabled="disabled" selected value="" style="color:gray">Year</option>
			  <option value="Present">Present</option>
			  <option value="2019">2019</option>
			  <option value="2018">2018</option>
			  <option value="2017">2017</option>
			  <option value="2016">2016</option>
			  <option value="2015">2015</option>
			  <option value="2014">2014</option>
			  <option value="2013">2013</option>
			  <option value="2012">2012</option>
			  <option value="2011">2011</option>
			  <option value="2010">2010</option>
			  <option value="2009">2009</option>
		 </select>
		<select name = "workToMonth" value = '<%=userresume.r_workToMonth%>' disabled>
		 <option disabled="disabled" selected value="" style="color:gray">Month</option>
			  <option value="Jan">Jan</option>
			  <option value="Feb">Feb</option>
			  <option value="Mar">Mar</option>
			  <option value="Apr">Apr</option>
			  <option value="May">May</option>
			  <option value="Jun">Jun</option>
			  <option value="Jul">Jul</option>
			  <option value="Aug">Aug</option>
			  <option value="Sep">Sep</option>
			  <option value="Oct">Oct</option>
			  <option value="Nov">Nov</option>
			  <option value="Dec">Dec</option>
		 </select><br><br>
		 Current Location<label style="color:red;">* &nbsp;</label> <input type="text" name="currLocation" placeholder = "Enter Current Location" size="120" value = '<%=userresume.r_currLocation%>' disabled/><br><br>
		 Duration of Notice Period &nbsp;<input type="text" name="notice" placeholder = "Select duration of your notice period" size="120" value = '<%=userresume.r_noticPeriod%>' disabled/>
		 <hr>
		 	  <label><b>Previous Employement</b></label><br><br>
	  Designation<label style="color:red;">* &nbsp;</label><input type="text" name="pdesc" placeholder = "Enter the previous designation" size="120" value = '<%=userresume.r_preCompDesc%>' disabled/><br><br>
	  Company<label style="color:red;">* &nbsp;</label><input type="text" name="pcomp" placeholder = "Enter the previous company" size="120" value = '<%=userresume.r_preCompany%>' disabled/><br><br>
	  Duration<label style="color:red;">* &nbsp;</label> <select name = "pworkFromYear" value = '<%=userresume.r_preFromYear%>' disabled>
	  		  <option disabled="disabled" selected value="" style="color:gray">Year</option>
			  <option value="Present">Present</option>
			  <option value="2019">2019</option>
			  <option value="2018">2018</option>
			  <option value="2017">2017</option>
			  <option value="2016">2016</option>
			  <option value="2015">2015</option>
			  <option value="2014">2014</option>
			  <option value="2013">2013</option>
			  <option value="2012">2012</option>
			  <option value="2011">2011</option>
			  <option value="2010">2010</option>
			  <option value="2009">2009</option>
		 </select>
		<select name = "pworkFromMonth" value = '<%=userresume.r_preFromMonth%>' disabled>
		 <option disabled="disabled" selected value="" style="color:gray">Month</option>
			  <option value="Jan">Jan</option>
			  <option value="Feb">Feb</option>
			  <option value="Mar">Mar</option>
			  <option value="Apr">Apr</option>
			  <option value="May">May</option>
			  <option value="Jun">Jun</option>
			  <option value="Jul">Jul</option>
			  <option value="Aug">Aug</option>
			  <option value="Sep">Sep</option>
			  <option value="Oct">Oct</option>
			  <option value="Nov">Nov</option>
			  <option value="Dec">Dec</option>
		 </select>
		<label style="color:#929cad;">to</label>
		<select name = "pworkToYear" value = '<%=userresume.r_preToYear%>' disabled>
	  		  <option disabled="disabled" selected value="" style="color:gray">Year</option>
			  <option value="Present">Present</option>
			  <option value="2019">2019</option>
			  <option value="2018">2018</option>
			  <option value="2017">2017</option>
			  <option value="2016">2016</option>
			  <option value="2015">2015</option>
			  <option value="2014">2014</option>
			  <option value="2013">2013</option>
			  <option value="2012">2012</option>
			  <option value="2011">2011</option>
			  <option value="2010">2010</option>
			  <option value="2009">2009</option>
		 </select>
		<select name = "pworkToMonth" value = '<%=userresume.r_preToMonth%>' disabled>
		 <option disabled="disabled" selected value="" style="color:gray">Month</option>
			  <option value="Jan">Jan</option>
			  <option value="Feb">Feb</option>
			  <option value="Mar">Mar</option>
			  <option value="Apr">Apr</option>
			  <option value="May">May</option>
			  <option value="Jun">Jun</option>
			  <option value="Jul">Jul</option>
			  <option value="Aug">Aug</option>
			  <option value="Sep">Sep</option>
			  <option value="Oct">Oct</option>
			  <option value="Nov">Nov</option>
			  <option value="Dec">Dec</option>
		 </select><br><br>	  
  </fieldset> <br>
  <fieldset>
	  <legend style="font-weight:bold;">  &nbsp; Technical Skills  &nbsp; </legend>
	  Main Skill 1<label style="color:red;">* &nbsp;</label> <input type="text" name="skills1" size="120" placeholder = "Enter your areas of expertise/specialization" value = '<%=userresume.r_skills%>' disabled/><br><br>
	  Main Skill 2<label style="color:red;">* &nbsp;</label> <input type="text" name="skills2" size="120" placeholder = "Enter your areas of expertise/specialization" value = '<%=userresume.r_skills2%>' disabled/><br><br>
	  Main Skill 3<label style="color:red;">* &nbsp;</label> <input type="text" name="skills3" size="120" placeholder = "Enter your areas of expertise/specialization" value = '<%=userresume.r_skills3%>' disabled/><br><br>
	  Main Skill 4<label style="color:red;">* &nbsp;</label> <input type="text" name="skills4" size="120" placeholder = "Enter your areas of expertise/specialization" value = '<%=userresume.r_skills4%>' disabled/><br><br>
	  Industry &nbsp;<select name = "industry" disabled>
		  <option disabled selected value="">Select Industry that you work for</option>
		  <option value="Account/Finance">Account/Finance</option>
		  <option value="Advertising">Advertising</option>
		  <option value="Agriculture/Diary">Agriculture/Diary</option>
		  <option value="Animation">Animation</option>
		  <option value="Architecture/Interior Designing">Architecture/Interior Designing</option>
		  <option value="Auto/Auto Ancillary">Auto/Auto Ancillary</option>
		  <option value="Aviation/Aerospace Firms">Aviation/Aerospace Firms</option>
		  <option value="Banking/Financial Services">Banking/Financial Services</option>
		  <option value="BPO/ITES">BPO/ITES</option>
		  <option value="Brewery/Distillery">Brewery/Distillery</option>
		  <option value="Broadcasting">Broadcasting</option>
		  <option value="Ceramics/Sanitary Ware">Ceramics/Sanitary Ware</option>
		  <option value="Chemicals/PetroChemical/Plastic/Rubber">Chemicals/PetroChemical/Plastic/Rubber</option>
		  <option value="Construction/Engineering/Cement/Metals">Construction/Engineering/Cement/Metals</option>
		  <option value="Consumer Durables">Consumer Durables</option>
		  <option value="Courier/Transportation/Freight">Courier/Transportation/Freight</option>
		  <option value="Education/Teaching/Training">Education/Teaching/Training</option>
		  <option value="Electricals/Switch Gears">Electricals/Switch Gears</option>
		  <option value="Export/Import">Export/Import</option>
		  <option value="Fertilizers/Pesticides">Fertilizers/Pesticides</option>
		  <option value="FMCG/Foods/Beverages">FMCG/Foods/Beverages</option>
		  <option value="Food Processing">Food Processing</option>
		  <option value="Fresher/Trainee">Fresher/Trainee</option>
		  <option value="Medical Devices/Equipment">Medical Devices/Equipment</option>
		  <option value="Medical/Healthcare/Hospital">Medical/Healthcare/Hospital</option>
		  <option value="Mining">Mining</option>
		  <option value="NGO/Social Service">NGO/Social Service</option>
		  <option value="Oil and Gas/Power/Energy">Oil and Gas/Power/Energy</option>
		  <option value="Pharma/Biotech/Clinical Research">Pharma/Biotech/Clinical Research</option>
		  <option value="Printing/Packaging">Printing/Packaging</option>
		  <option value="Real Estate/Property">Real Estate/Property</option>
		  <option value="Strategy/Management Consulting Firm">Strategy/Management Consulting Firm</option>
		  <option value="Textiles/Garments">Textiles/Garments</option>
		  <option value="Water Treatment/Waste Management">Water Treatment/Waste Management</option>
		  <option value="Other">Other</option>
	  </select> <br><br>
	  Functional Area &nbsp;<select name = "funcArea" value = '<%=userresume.r_funcArea%>' disabled>
		  <option style="color:#929cad;" value="" disabled selected>Select the department that you work in</option>
		  <option value="Accounts/Finance/Tax/Audit">Accounts/Finance/Tax/Audit</option>
		  <option value="Analytics & Business Intelligence">Analytics & Business Intelligence</option>
		  <option value="Architecture/Interior Designing">Architecture/Interior Designing </option>
		  <option value="Banking/Insurance">Banking/Insurance</option>
		  <option value="Beauty/Fitness/Spa">Beauty/Fitness/Spa</option>
		  <option value="Engineering Design/R&D">Engineering Design/R&D</option>
		  <option value="Import/Export">Import/Export</option>
		  <option value="Fashion/Garments">Fashion/Garments</option>
		  <option value="Hotels/Resturants">Hotels/Resturants</option>
		  <option value="HR/Administration">HR/Administration</option>
		  <option value="IT-Hardware">IT-Hardware</option>
		  <option value="IT-Software">IT-Software</option>
		  <option value="ITES/BPO/KPO">ITES/BPO/KPO</option>
		  <option value="Legal">Legal</option>
		  <option value="Marketing">Marketing</option>
		  <option value="Self Employed/Consultancy">Self Employed/Consultancy</option>
		  <option value="Teaching/Education">Teaching/Education</option>
		  <option value="TV/Film/Production">TV/Film/Production</option>
		  <option value="Web/Graphics Designer/Visualizer">Web/Graphics Designer/Visualizer</option>
		  <option value="Other">Other</option>
	  </select> <br><br>
	  Role &nbsp;<input type="text" name="role" placeholder = "Enter the role that you work in" size="120" value = '<%=userresume.r_role%>' disabled><br><br>
	  </fieldset><br>
	  <fieldset>
	  <legend style="font-weight:bold;">  &nbsp; Education Details  &nbsp; </legend>
	  Highest Education<label style="color:red;">* &nbsp;</label><input type="text" name="highestEdu" placeholder = "Enter your highest education" size="120" value = '<%=userresume.r_highestEdu%>' disabled/><br><br>
	  Course<label style="color:red;">* &nbsp;</label><input type="text" name="course" placeholder = "Enter your course" size="120" value = '<%=userresume.r_course%>' disabled/><br><br>
	  Specialization<label style="color:red;">* &nbsp;</label><input type="text" name="spe" placeholder = "Enter specialization" size="120" value = '<%=userresume.r_spec%>' disabled/><br><br>
	  University/College<label style="color:red;">* &nbsp;</label><input type="text" name="college" placeholder = "Institute Name" size="120" value = '<%=userresume.r_university%>' disabled/><br><br>
	  Course Type<label style="color:red;">* &nbsp;</label><select name = "courseType" value = '<%=userresume.r_courseType%>' disabled>
		  <option style="color:#929cad;" value="" disabled selected>Select your course type</option>
		  <option value="Full Time">Full Time</option>
		  <option value="Part Time">Part Time</option>
		  <option value="Correspondence">Correspondence</option>
		  </select><br><br>
	  Passing Year<label style="color:red;">* &nbsp;</label><input type="text" name="passyear" placeholder = "Passing year" size="120" value = '<%=userresume.r_passYear%>' disabled/>
	  	  <hr>
	  <label><b>Previous Qualification</b></label><br><br>
	  Course<label style="color:red;">* &nbsp;</label><input type="text" name="pCourse" placeholder = "Enter your previous degree specialization" size="120" value = '<%=userresume.r_prevDegree%>' disabled/><br><br>
	  University/College<label style="color:red;">* &nbsp;</label><input type="text" name="pCollege" placeholder = "Enter your previous university" size="120" value = '<%=userresume.r_prevUniversity%>' disabled/><br><br>
	  Passing Year<label style="color:red;">* &nbsp;</label><input type="text" name="prepassyear" placeholder = "Passing year" size="120" value = '<%=userresume.r_prePassYear%>' disabled/><br><br>
	  
	  </fieldset>
	  <br><input type="submit" value="DELETE"></input>
	  </form>
  </div>
</div>
</body>
</html>