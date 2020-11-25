package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Job;
import com.mvc.util.DBConnection;

public class DAOCreateJob {
	public String createUserJob(Job jobBean) throws ClassNotFoundException
	 {		 
		 String jobTitle = jobBean.getJobTitle();
		 String jDesc = jobBean.getDescription();
		 String salary = jobBean.getSalary();
		 String jobType = jobBean.getJobType();
		 String jSkills = jobBean.getjSkills();
		 String jcompanyName = jobBean.getCompanyName();
		 String jcompDesc = jobBean.getCompDesc();
		 String jcity = jobBean.getCity();
		 String creationDate = jobBean.getCreationDate();
		 String endDate = jobBean.getEndDate();
		 String experience = jobBean.getExperience();
		 String jobRole = jobBean.getJobRole();
		 String jIndustryType = jobBean.getjIndustryType();
		 String jFuncArea = jobBean.getjFuncArea();
		 String jEducation = jobBean.getjEducation();
		 String jContactPerson = jobBean.getjContactPerson();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 
			 Statement st = con.createStatement();
			 String query = "insert into userjobs(jobid,jobTitle,description,salary,jobType,skills,companyName,compDesc,city,creationDate,"
			 		+ "endDate,jexperience,jRole,jIndustryType,jFuncArea,jEducation,jContactPerson) values (JOBSEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
			 preparedStatement = con.prepareStatement(query);
			 preparedStatement.setString(1, jobTitle);
			 preparedStatement.setString(2, jDesc);
			 preparedStatement.setString(3, salary);
			 preparedStatement.setString(4, jobType);
			 preparedStatement.setString(5, jSkills);
			 preparedStatement.setString(6, jcompanyName);
			 preparedStatement.setString(7, jcompDesc);
			 preparedStatement.setString(8, jcity);
			 preparedStatement.setString(9, creationDate);
			 preparedStatement.setString(10, endDate);
			 preparedStatement.setString(11, experience);
			 preparedStatement.setString(12, jobRole);
			 preparedStatement.setString(13, jIndustryType);
			 preparedStatement.setString(14, jFuncArea);
			 preparedStatement.setString(15, jEducation);
			 preparedStatement.setString(16, jContactPerson);
			 
			 int i= preparedStatement.executeUpdate();
			 if (i!=0) {
				System.out.println("insert job success");
			    return "SUCCESS"; 
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } catch(NullPointerException e) { 
	         System.out.print("NullPointerException Caught"); 
	     } 
		 return "Oops.. Something went wrong there..!";  
	 }
}

