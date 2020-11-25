package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.CRegister;
import com.mvc.util.DBConnection;

public class DAOEditCProfile {
	public String editCUserProfile(CRegister editCUser) throws ClassNotFoundException {
		String email = editCUser.getEmail();
		 String password = editCUser.getPassword();
		 String companyName = editCUser.getCompanyName();
		 String industryType = editCUser.getIndustryType();
		 String orgType = editCUser.getOrgType();
		 String contactPerson = editCUser.getContactPerson();
		 String designation = editCUser.getDesignation();
		 String address = editCUser.getAddress();
		 String country = editCUser.getCountry();
		 String state = editCUser.getState();
		 String city = editCUser.getCity();
		 String pincode = editCUser.getPincode();
		 String mobileNumber = editCUser.getMobileNumber();
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			con = DBConnection.createConnection();			
			String query = "update compregister set CEMAIL = ?, CPSWD = ?, COMPANYNAME = ?, INDUSTRYTYPE = ?, COMPANYTYPE = ?, CONTACTPERSON = ?, DESIGNATION = ?, "
					+ "ADDRESS = ?, COUNTRY = ?, STATE = ?, CITY = ?, PINCODE = ?, CMNUMBER = ? where CID = '"+DAOIntro.userID+"'";
			 preparedStatement = con.prepareStatement(query);
			 preparedStatement.setString(1, email);
			 preparedStatement.setString(2, password);
			 preparedStatement.setString(3, companyName);
			 preparedStatement.setString(4, industryType);
			 preparedStatement.setString(5, orgType);
			 preparedStatement.setString(6, contactPerson);
			 preparedStatement.setString(7, designation);
			 preparedStatement.setString(8, address);
			 preparedStatement.setString(9, country);
			 preparedStatement.setString(10, state);
			 preparedStatement.setString(11, city);
			 preparedStatement.setString(12, pincode);
			 preparedStatement.setString(13, mobileNumber);
			 int i= preparedStatement.executeUpdate();
			if (i!=0) {
				DAOViewCProfile.c_email = email;
				DAOViewCProfile.c_password = password;
				DAOViewCProfile.c_companyName = companyName;
				DAOViewCProfile.c_industryType = industryType;
				DAOViewCProfile.c_orgType = orgType;
				DAOViewCProfile.c_contactPerson = contactPerson;
				DAOViewCProfile.c_designation = designation;
				DAOViewCProfile.c_address = address;
				DAOViewCProfile.c_country = country;
				DAOViewCProfile.c_state = state;
				DAOViewCProfile.c_city = city;
				DAOViewCProfile.c_pincode = pincode;
				DAOViewCProfile.c_mnumber = mobileNumber;
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
