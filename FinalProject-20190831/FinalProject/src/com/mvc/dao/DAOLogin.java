package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Register;
import com.mvc.util.DBConnection;

public class DAOLogin {
	public static String userID, userType;
	public String loginUser(Register loginBean) throws ClassNotFoundException
	 {
		 String email = loginBean.getEmail();
		 String password = loginBean.getPassword();
		 
		 System.out.println("email = " +email);
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 System.out.println("userRegistered2");
			 Statement st = con.createStatement();
			 String query = "select id,username,EMAIL,PSWD,LOGINTYPE from userregister where email ='"+email+"' "; 
	         ResultSet result = st.executeQuery(query);
	         result.next();
	         
	         String strEmail = result.getString("email");
	         System.out.println("email = " +strEmail);
	         
	         String strName = result.getString("username");
	         System.out.println("name = " +strName);

	         if(strEmail.equals(email)) {
	        	 System.out.println("email available");
	        	 if(result.getString("pswd").equals(password)) {
	        		 System.out.println("correct password");
	    			 String query1 = "update userregister set LOGINSTATUS = '1' where email ='"+email+"' ";
	    			 preparedStatement = con.prepareStatement(query1);
	    			 int i= preparedStatement.executeUpdate();
	    			 if (i!=0) {
	    				System.out.println("Valid User");
	    			 	System.out.println("user id == " +result.getString("id"));
//	    			 	userID = result.getString("id");
//	    			 	System.out.println("global user id == " +userID);
//	    			 	String strType = result.getString("LOGINTYPE");
//	    			 	userType = result.getString("LOGINTYPE");
	    			 	DAOIntro.userID = result.getString("id");
	    			 	System.out.println("global user id == " +DAOIntro.userID);
	    			 	DAOIntro.uType = "Candidate";
		    			DAOIntro.global_uname = strName;
		    			System.out.println("global username == " +DAOIntro.global_uname);
	    				return "Candidate";
	    			 }
	        	 } else {
	        		 return "WRONG PASSWORD";
	        	 }
	         } else {
	        	 return "INVALID EMAIL";
	         }
	        
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } catch(NullPointerException e) { 
	         System.out.print("NullPointerException Caught"); 
	     } 
		 return "Oops.. Something went wrong there..!";  
	 }
}
