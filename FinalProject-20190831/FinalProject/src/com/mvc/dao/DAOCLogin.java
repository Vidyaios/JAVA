package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.CRegister;
import com.mvc.util.DBConnection;

public class DAOCLogin {
	public static String userID, userType;
	public String loginCompany(CRegister loginBean) throws ClassNotFoundException
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
			 String query = "select cid,CEMAIL,CPSWD from compregister where cemail ='"+email+"' "; 
	         ResultSet result = st.executeQuery(query);
	         result.next();
	         
	         String strEmail = result.getString("cemail");
	         System.out.println("email = " +strEmail);
	         
	         if(strEmail.equals(email)) {
	        	 System.out.println("email available");
	        	 if(result.getString("cpswd").equals(password)) {
	        		 System.out.println("correct password");
	    			 String query1 = "update compregister set LOGINSTATUS = '1' where cemail ='"+email+"' ";
	    			 preparedStatement = con.prepareStatement(query1);
	    			 int i= preparedStatement.executeUpdate();
	    			 if (i!=0) {
	    				System.out.println("Valid User");
	    			 	System.out.println("user id == " +result.getString("cid"));
	    			 	DAOIntro.userID = result.getString("cid");
	    			 	System.out.println("global user id == " +DAOIntro.userID);
	    			 	DAOIntro.uType = "Company";
	    				return "Company";
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
