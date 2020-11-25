package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.CRegister;
import com.mvc.bean.Job;
import com.mvc.util.DBConnection;

public class DAOCompany {
	public static String c_username, c_password, c_email, c_type;

	public CRegister getCompanyDetails() throws ClassNotFoundException {
		
		Connection connection = null;
		try {
			 connection = DBConnection.createConnection();
			 System.out.println("user profile");
		     Statement st = connection.createStatement();
		     String sql = "SELECT CEMAIL,CPSWD,COMPANYNAME,INDUSTRYTYPE,COMPANYTYPE,CONTACTPERSON,DESIGNATION,ADDRESS,COUNTRY,STATE,"
		     		+ "CITY,PINCODE,CMNUMBER from compregister where ID = '"+DAOIntro.userID+"' ";
		     System.out.println("company profile details called == " +sql);
		     ResultSet result = st.executeQuery(sql);
		     if (result.next()) {
		        CRegister reg = new CRegister();
		        reg.setEmail(result.getString(1));
		        reg.setPassword(result.getString(2)); 
		        reg.setCompanyName(result.getString(3));
		        reg.setIndustryType(result.getString(4));
		        reg.setOrgType(result.getString(5));
		        reg.setContactPerson(result.getString(6));
		        reg.setDesignation(result.getString(7));
		        reg.setAddress(result.getString(8));
		        reg.setCountry(result.getString(9));
		        reg.setState(result.getString(10));
		        reg.setCity(result.getString(11));
		        reg.setPincode(result.getString(12));
		        reg.setMobileNumber(result.getString(13));
		        
		        c_email = result.getString(1);
		        c_password = result.getString(2);
		        c_type = result.getString(5);
		        System.out.println("company profile details called == " +reg);
		        return reg;
		     }
		  } catch (SQLException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } catch (ClassNotFoundException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		  return null;
	}
	
	
	public List<Job> getAllJobs() {
        ArrayList<Job> jobList = new ArrayList<Job>();
        try(Connection conn = DBConnection.createConnection()) {
            String sql = "SELECT jobid, jobTitle, description, salary, jobType, skills, companyName, compDesc, city, "
            		+ "creationDate, endDate, jexperience, jRole, jIndustryType, jFuncArea, jEducation, jContactPerson from userjobs";         
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
