package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.CRegister;
import com.mvc.util.DBConnection;

public class DAOCRegister {
	public String registerCompany(CRegister registerBean) throws ClassNotFoundException
	 {
		 String email = registerBean.getEmail();
		 String password = registerBean.getPassword();
		 String companyName = registerBean.getCompanyName();
		 String industryType = registerBean.getIndustryType();
		 String orgType = registerBean.getOrgType();
		 String contactPerson = registerBean.getContactPerson();
		 String designation = registerBean.getDesignation();
		 String address = registerBean.getAddress();
		 String country = registerBean.getCountry();
		 String state = registerBean.getState();
		 String city = registerBean.getCity();
		 String pincode = registerBean.getPincode();
		 String mobileNumber = registerBean.getMobileNumber();
		 
		 System.out.println("industry type == " +industryType);
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 
			 Statement st = con.createStatement();
//			 String query1 = "select cemail,cpswd from compregister"; 
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
				 String query = "insert into compregister(CID,CEMAIL,CPSWD,COMPANYNAME,INDUSTRYTYPE,COMPANYTYPE,CONTACTPERSON,DESIGNATION,ADDRESS,COUNTRY,STATE,CITY,PINCODE,CMNUMBER,LOGINSTATUS) "
				 		+ "values (CREGSEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,1)"; 
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
					 con = DBConnection.createConnection();
					 System.out.println("userRegistered2");
					 Statement st1 = con.createStatement();
					 String query2 = "select CID,CEMAIL from compregister where cemail ='"+email+"' "; 
			         ResultSet result = st.executeQuery(query2);
			         result.next();
			         					 
	    			 DAOIntro.userID = result.getString("cid");
	    			 System.out.println("global user id == " +DAOIntro.userID);
	    			 DAOIntro.uType = "Company";
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


