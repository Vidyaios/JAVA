package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.util.DBConnection;

public class DAODeleteJob {
	public String userJobDelete() throws ClassNotFoundException
	 {		 
		 System.out.println("delete job id == " +DAOIntro.global_jobID);
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 String query = "DELETE from userjobs where jobid = '"+DAOIntro.global_jobID+"'"; 
			 preparedStatement = con.prepareStatement(query);
			 int i= preparedStatement.executeUpdate();
			 if (i!=0) {
				System.out.println("delete job User");
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
