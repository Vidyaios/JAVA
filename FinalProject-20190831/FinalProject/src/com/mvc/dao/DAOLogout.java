package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class DAOLogout {
	public String logoutUser() throws ClassNotFoundException
	 {
//    	Preferences prefs = Preferences.userRoot();
//    	System.out.println("home screen user id == " +prefs.get("userID", null));
//		 String strID = prefs.get("userID", null);
//		 System.out.println("home screen user id == " +strID);
		 
		 System.out.println("home screen user id == " +DAOIntro.userID);
		 System.out.println("home screen user id == " +DAOIntro.userID);
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 String query;
			 if (DAOIntro.uType.equals("Candidate")) {
				 query = "update userregister set LOGINSTATUS = '0' where id ='"+DAOIntro.userID+"' "; 
			 } else {
				 query = "update compregister set LOGINSTATUS = '0' where cid ='"+DAOIntro.userID+"' "; 
			 }
			 preparedStatement = con.prepareStatement(query);
			 int i= preparedStatement.executeUpdate();
			 if (i!=0) {
				System.out.println("logout User");
				DAOCreateResume.r_name = "";
				DAOCreateResume.r_email = "";
				DAOCreateResume.r_number = "";
				DAOCreateResume.r_workexpyear = "";
				DAOCreateResume.r_workexpmon = "";
				DAOCreateResume.r_currDesc = "";
				DAOCreateResume.r_currComp = "";
				DAOCreateResume.r_salaryL = "";
				DAOCreateResume.r_salaryT = "";
				DAOCreateResume.r_workFromYear = "";
				DAOCreateResume.r_workFromMonth = "";
				DAOCreateResume.r_currLocation ="";
				DAOCreateResume.r_noticPeriod = "";
				DAOCreateResume.r_skills = "";
				DAOCreateResume.r_indusrty = "";
				DAOCreateResume.r_funcArea = "";
				DAOCreateResume.r_role = "";
				DAOCreateResume.r_highestEdu = ""; 
				DAOCreateResume.r_course = ""; 
				DAOCreateResume.r_spec = "";
				DAOCreateResume.r_university = "";
				DAOCreateResume.r_courseType = "";
				DAOCreateResume.r_passYear = "";
				DAOCreateResume.r_workToYear = "";
				DAOCreateResume.r_workToMonth = "";
				DAOCreateResume.r_skills2 = "";
				DAOCreateResume.r_skills3 = "";
				DAOCreateResume.r_skills4 = "";
				DAOCreateResume.r_preCompany = "";
				DAOCreateResume.r_preCompDesc = "";
				DAOCreateResume.r_preFromYear = "";
				DAOCreateResume.r_preFromMonth = "";
				DAOCreateResume.r_preToYear = "";
				DAOCreateResume.r_preToMonth = "";
				DAOCreateResume.r_prevDegree = "";
				DAOCreateResume.r_prevUniversity = "";
				DAOCreateResume.r_prePassYear = "";
				DAOCreateResume.r_lang1 = "";
				DAOCreateResume.r_lang2 = "";
				DAOCreateResume.r_lang3 = "";
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
