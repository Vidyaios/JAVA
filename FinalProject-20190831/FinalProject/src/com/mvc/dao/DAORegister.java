package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Register;
import com.mvc.util.DBConnection;

public class DAORegister {
	public String registerUser(Register registerBean) throws ClassNotFoundException
	 {
		 String username = registerBean.getUsername();
		 String password = registerBean.getPassword();
		 String email = registerBean.getEmail();
		 String type = registerBean.getType();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 
			 Statement st = con.createStatement();
//			 String query1 = "select EMAIL,PSWD from userregister"; 
//	         ResultSet result1 = st.executeQuery(query1);
//	         result1.next();
//	         
//	         
//	         String strEmail = result1.getString("email");
//			 System.out.println("available " +strEmail);
//			 
//			 if(strEmail.equals(email)) {
//				 System.out.println("user already registered");
//				 return "ALREADY REGISTERED";
//			 } else {
				 String query = "insert into userregister(ID,USERNAME,PSWD,EMAIL,LOGINTYPE,LOGINSTATUS) values (REGSEQ.nextval,?,?,?,?,1)"; 
				 preparedStatement = con.prepareStatement(query);
				 preparedStatement.setString(1, username);
				 preparedStatement.setString(2, password);
				 preparedStatement.setString(3, email);
				 preparedStatement.setString(4, type);
				 int i= preparedStatement.executeUpdate();
				 if (i!=0) {
					 con = DBConnection.createConnection();
					 System.out.println("userRegistered2");
					 Statement st1 = con.createStatement();
					 String query2 = "select id,EMAIL from userregister where email ='"+email+"' "; 
			         ResultSet result = st.executeQuery(query2);
			         result.next();
			         					 
	    			 DAOIntro.userID = result.getString("id");
	    			 System.out.println("global user id == " +DAOIntro.userID);
	    			 DAOIntro.uType = "Candidate";
	    			 DAOIntro.global_uname = username;
	    			 System.out.println("global username == " +DAOIntro.global_uname);
					 return "SUCCESS"; 
				 }
//			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } catch(NullPointerException e) { 
	         System.out.print("NullPointerException Caught"); 
	     } 
		 return "Oops.. Something went wrong there..!";  
	 }
}
