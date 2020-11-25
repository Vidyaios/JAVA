package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.Job;
import com.mvc.util.DBConnection;

public class DAOIntro {
	
	public static String uType, userID, global_jobID, global_uname;
	
	public String userIntro() throws ClassNotFoundException
	 {		 
		 System.out.println("home screen user id == " +DAOLogin.userID);
		 
		 Connection con = null;
//		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 Statement st = con.createStatement();
			 String query = "select LOGINSTATUS,USERNAME,LOGINTYPE from userregister where id ='"+DAOLogin.userID+"' "; 
			 ResultSet result = st.executeQuery(query);
			 result.next();
			 System.out.print("fine"); 
			 if (result.getString("id").equals("1")) {
					System.out.print("1"); 
				return result.getString("LOGINTYPE");
			 } else if (result.getString("id").equals("0")) {
					System.out.print("0"); 
				 return "HOME";
			 } else {
				 return "FAILURE";
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } catch(NullPointerException e) { 
	         System.out.print("NullPointerException Caught"); 
	     } 
		 return "Oops.. Something went wrong there..!";  
	 }
	
	
	public List<Job> getAllJobs() {
        ArrayList<Job> jobList = new ArrayList<Job>();
        try(Connection conn = DBConnection.createConnection()) {
            String sql = "SELECT jobid, jobTitle, description, salary, jobType, skills, companyName, compDesc, city, "
            		+ "creationDate, endDate, jexperience, jRole, jIndustryType, jFuncArea, jEducation, jContactPerson from userjobs where job_userid = '"+DAOIntro.userID+"'";         
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                Job job = new Job();
                job.setJobID(result.getString(1));
                job.setJobTitle(result.getString(2));
                job.setDescription(result.getString(3));
                job.setSalary(result.getString(4));
                job.setJobType(result.getString(5));
                job.setjSkills(result.getString(6));
                job.setCompanyName(result.getString(7));
                job.setCompDesc(result.getString(8));
                job.setCity(result.getString(9));
                job.setCreationDate(result.getString(10));
                job.setEndDate(result.getString(11));
                job.setExperience(result.getString(12));
                job.setJobRole(result.getString(13));
                job.setjIndustryType(result.getString(14));
                job.setjFuncArea(result.getString(15));
                job.setjEducation(result.getString(16));
                job.setjContactPerson(result.getString(17));
                jobList.add(job);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompany.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
        return jobList;      
    }
}

