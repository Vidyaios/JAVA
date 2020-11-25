package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.Register;
import com.mvc.util.DBConnection;

public class DAOEditProfile {
	public String editUserProfile(Register editUser) throws ClassNotFoundException {
		String username = editUser.getUsername();
		 String password = editUser.getPassword();
		 String email = editUser.getEmail();
//		 String type = editUser.getType();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			con = DBConnection.createConnection();
			String query = "update userregister set USERNAME = ?, PSWD = ?, EMAIL = ? where id = '"+DAOLogin.userID+"' "; 
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			int i= preparedStatement.executeUpdate();
			if (i!=0) {
				DAOViewProfile.p_username = editUser.getUsername();
				DAOViewProfile.p_email = editUser.getEmail();
				DAOViewProfile.p_password = editUser.getPassword();
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
