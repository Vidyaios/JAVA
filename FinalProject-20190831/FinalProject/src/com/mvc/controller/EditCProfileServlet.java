package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.CRegister;
import com.mvc.bean.Register;
import com.mvc.dao.DAOEditCProfile;
import com.mvc.dao.DAOViewCProfile;

public class EditCProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditCProfileServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 String companyName = request.getParameter("cname");
		 String industryType = request.getParameter("indusType");
		 String orgType = request.getParameter("type");
		 String contactPerson = request.getParameter("pname");
		 String designation = request.getParameter("desi");
		 String address = request.getParameter("addr");
		 String country = request.getParameter("country");
		 String state = request.getParameter("state");
		 String city = request.getParameter("city");
		 String pincode = request.getParameter("pincode");
		 String mobileNumber = request.getParameter("mnumber");
		 
		 CRegister editcbean = new CRegister();
		 editcbean.setEmail(email);
		 editcbean.setPassword(password); 
		 editcbean.setCompanyName(companyName);
		 editcbean.setIndustryType(industryType);
		 editcbean.setOrgType(orgType);
		 editcbean.setContactPerson(contactPerson);
		 editcbean.setDesignation(designation);
		 editcbean.setAddress(address);
		 editcbean.setCountry(country);
		 editcbean.setState(state);
		 editcbean.setCity(city);
		 editcbean.setPincode(pincode);
		 editcbean.setMobileNumber(mobileNumber);
		 		 
		 DAOEditCProfile editusecrDao = new DAOEditCProfile();
		 
		 String edituser;
		try {
			edituser = editusecrDao.editCUserProfile(editcbean);
			if(editcbean.equals("SUCCESS")) {
				request.setAttribute("errMessage", "Updated Successfully");
				request.getRequestDispatcher("/EditCProfile.jsp").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", edituser);
				 request.getRequestDispatcher("/EditCProfile.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get company profile details called");
        RequestDispatcher dispatcher;
		DAOViewCProfile viewCDao = new DAOViewCProfile();
		try {
	        CRegister reg = viewCDao.getCompanyDetails();
	        System.out.println("company profile details called");
	        request.setAttribute("cprofile", reg);
	        dispatcher = request.getRequestDispatcher("/EditCProfile.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
