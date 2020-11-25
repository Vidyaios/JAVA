package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Register;
import com.mvc.util.DBConnection;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DAOViewProfile {
	public static String p_username, p_password, p_email, p_type;

	public Register getUserDetails() throws ClassNotFoundException {
		
		Connection connection = null;
		try {
			 connection = DBConnection.createConnection();
			 System.out.println("user profile");
		     Statement st = connection.createStatement();
		     String sql = "SELECT USERNAME,PSWD,EMAIL,LOGINTYPE from userregister where ID = '"+DAOIntro.userID+"' ";
		     System.out.println("profile details called == " +sql);
		     ResultSet result = st.executeQuery(sql);
		     if (result.next()) {
		        Register reg = new Register();
		        reg.setUsername(result.getString(1));
		        reg.setPassword(result.getString(2));
		        reg.setEmail(result.getString(3));
		        reg.setType(result.getString(4));
		        p_username = result.getString(1);
		        p_password = result.getString(2);
		        p_email = result.getString(3);
		        p_type = result.getString(4);
		        System.out.println("profile details called == " +reg);
		        
		        return reg;
		     }
		  } catch (SQLException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } catch (ClassNotFoundException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		  return null;
	}
}
