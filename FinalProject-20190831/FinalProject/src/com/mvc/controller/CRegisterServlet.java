package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.CRegister;
import com.mvc.dao.DAOCRegister;
import com.mvc.dao.DAOIntro;

public class CRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public CRegisterServlet() {
	 }
	 	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 
		 CRegister registerBean = new CRegister();
		 registerBean.setEmail(email);
		 registerBean.setPassword(password); 
		 registerBean.setCompanyName(companyName);
		 registerBean.setIndustryType(industryType);
		 registerBean.setOrgType(orgType);
		 registerBean.setContactPerson(contactPerson);
		 registerBean.setDesignation(designation);
		 registerBean.setAddress(address);
		 registerBean.setCountry(country);
		 registerBean.setState(state);
		 registerBean.setCity(city);
		 registerBean.setPincode(pincode);
		 registerBean.setMobileNumber(mobileNumber);
		 		 
		 DAOCRegister registerDao = new DAOCRegister();
		 
		 String cUserRegistered;
		try {
			cUserRegistered = registerDao.registerCompany(registerBean);
			if(cUserRegistered.equals("ALREADY REGISTERED")) {
				request.setAttribute("errMessage", "User Already Registered. Please try a different email.");
				request.getRequestDispatcher("/CRegister.jsp").forward(request, response);
			 } else if (cUserRegistered.equals("SUCCESS")) {
				 DAOIntro.uType = "Company";
				 System.out.println("Success");
				 System.out.println("Company");
				 request.getRequestDispatcher("/CompanyServlet").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", cUserRegistered);
				 request.getRequestDispatcher("/CRegister.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
