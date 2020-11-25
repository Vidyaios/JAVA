package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.Job;
import com.mvc.util.DBConnection;


public class DAOViewJob {
	
	public static String j_title = "", j_desc = "", j_salary = "", j_type = "", j_skills = "", j_companyName = "", j_companyDesc = "", j_city = "", 
	j_creationDate = "", j_endDate = "", j_experience = "", j_role = "", j_industryType = "", j_FuncArea = "", j_education = "", j_contactPerson = "";
	
	
public Job getJobDetails(String jobID) throws ClassNotFoundException {		
		
		Connection connection = null;
		try {
			 connection = DBConnection.createConnection();
			 System.out.println("job view");
		     Statement st = connection.createStatement();
		     String sql = "SELECT jobTitle,description,salary,jobType,skills,companyName,compDesc,city,creationDate,"
		     		+ "endDate,jexperience,jRole,jIndustryType,jFuncArea,jEducation,jContactPerson from userjobs where jobid = '"+jobID+"' ";
		     System.out.println("profile details called == " +sql);
		     ResultSet result = st.executeQuery(sql);
		     if (result.next()) {
		    	Job reg = new Job();
		        reg.setJobTitle(result.getString(1));
		        reg.setDescription(result.getString(2));
		        reg.setSalary(result.getString(3));
		        reg.setJobType(result.getString(4));
		        reg.setjSkills(result.getString(5));
		        reg.setCompanyName(result.getString(6));
		        reg.setCompDesc(result.getString(7));
		        reg.setCity(result.getString(8));
		        reg.setCreationDate(result.getString(9));
		        reg.setEndDate(result.getString(10));
		        reg.setExperience(result.getString(11));
		        reg.setJobRole(result.getString(12));
		        reg.setjIndustryType(result.getString(13));
		        reg.setjFuncArea(result.getString(14));
		        reg.setjEducation(result.getString(15));
		        reg.setjContactPerson(result.getString(16));

		        System.out.println("job details called == " +reg);

		    	j_title = result.getString(1);
		    	j_desc = result.getString(2);
		    	j_salary = result.getString(3);
		    	j_type = result.getString(4);
		    	j_skills = result.getString(5);
		    	j_companyName = result.getString(6);
		    	j_companyDesc = result.getString(7);
		    	j_city = result.getString(8);
		    	j_creationDate = result.getString(9);
		    	j_endDate = result.getString(10);
		    	j_experience = result.getString(11);
		    	j_role = result.getString(12);
		    	j_industryType = result.getString(13);
		    	j_FuncArea = result.getString(14);
		    	j_education = result.getString(15);
		    	j_contactPerson = result.getString(16);
		    	DAOIntro.global_jobID = jobID;
		        return reg;
		     }
		  } catch (SQLException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } catch (ClassNotFoundException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		  return null;
	}
}
