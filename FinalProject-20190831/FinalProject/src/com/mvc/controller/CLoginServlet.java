package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.CRegister;
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAOCLogin;

public class CLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CLoginServlet() {
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");		 
		 
		 CRegister loginBean = new CRegister();
		 loginBean.setEmail(email);
		 loginBean.setPassword(password); 
		 		 
		 DAOCLogin loginDao = new DAOCLogin();
		 
		 String userClogin;
		try {
			userClogin = loginDao.loginCompany(loginBean);
			if(userClogin.equals("INVALID EMAIL")) {
				request.setAttribute("errMessage", userClogin);
				request.getRequestDispatcher("/CLogin.jsp").forward(request, response);
			 } else if (userClogin.equals("WRONG PASSWORD")) {
				 request.setAttribute("errMessage", userClogin);
				 request.getRequestDispatcher("/CLogin.jsp").forward(request, response);
			 } else if (userClogin.equals("Company")) {
				 DAOIntro.uType = "Company";
				 System.out.println("Company");
//				 request.getRequestDispatcher("/HomeCompany.jsp").forward(request, response);
				 request.getRequestDispatcher("/CompanyServlet").forward(request, response);
			 } else {
			 	 System.out.println("failure");
				 request.setAttribute("errMessage", userClogin);
				 request.getRequestDispatcher("/CLogin.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
