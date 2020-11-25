package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.CRegister;
import com.mvc.util.DBConnection;

public class DAOViewCProfile {
	public static String c_email, c_password, c_companyName, c_industryType, c_orgType, c_contactPerson, c_designation, c_address, c_country, c_state, c_city, c_pincode, c_mnumber;

	public CRegister getCompanyDetails() throws ClassNotFoundException {
		
		Connection connection = null;
		try {
			 connection = DBConnection.createConnection();
			 System.out.println("user profile");
		     Statement st = connection.createStatement();
		     String sql = "SELECT CEMAIL,CPSWD,COMPANYNAME,INDUSTRYTYPE,COMPANYTYPE,CONTACTPERSON,DESIGNATION,ADDRESS,COUNTRY,STATE,"
		     		+ "CITY,PINCODE,CMNUMBER from compregister where CID = '"+DAOIntro.userID+"' ";
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
		        c_companyName = result.getString(3);
		        c_industryType = result.getString(4);
		        c_orgType = result.getString(5);
		        c_contactPerson = result.getString(6);
		        c_designation = result.getString(7);
		        c_address = result.getString(8);
		        c_country = result.getString(9);
		        c_state = result.getString(10);
		        c_city = result.getString(11);
		        c_pincode = result.getString(12);
		        c_mnumber = result.getString(13);
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
}
