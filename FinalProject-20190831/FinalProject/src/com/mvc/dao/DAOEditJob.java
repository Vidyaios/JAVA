package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Job;
import com.mvc.util.DBConnection;

public class DAOEditJob {
	public String editUserJob(Job jobBean) throws ClassNotFoundException
	 {		
		System.out.println("global job id == " +DAOIntro.global_jobID);
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
			 String query = "update userjobs set jobTitle = ?,description = ?,salary = ?,jobType = ?,skills = ?,companyName = ?,compDesc = ?,city = ?,creationDate = ?,"
			 		+ "endDate = ?,jexperience = ?,jRole = ?,jIndustryType = ?,jFuncArea = ?,jEducation = ?,jContactPerson = ? where jobid = '"+DAOIntro.global_jobID+"'"; 
			 System.out.println("query == " +query);
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
				System.out.println("update job success");
				DAOViewJob.j_title = jobTitle;
				DAOViewJob.j_desc = jDesc;
				DAOViewJob.j_salary = salary;
				DAOViewJob.j_type = jobType;
				DAOViewJob.j_skills = jSkills;
				DAOViewJob.j_companyName = jcompanyName;
				DAOViewJob.j_companyDesc = jcompDesc;
				DAOViewJob.j_city = jcity;
				DAOViewJob.j_creationDate = creationDate;
				DAOViewJob.j_endDate = endDate;
				DAOViewJob.j_experience = experience;
				DAOViewJob.j_role = jobRole;
				DAOViewJob.j_industryType = jIndustryType;
				DAOViewJob.j_FuncArea = jFuncArea;
				DAOViewJob.j_education = jEducation;
				DAOViewJob.j_contactPerson = jContactPerson;
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
