package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Register;
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAOLogin;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String userType;
	
	public LoginServlet() {
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");		 
		 
		 Register loginBean = new Register();
		 loginBean.setEmail(email);
		 loginBean.setPassword(password); 
		 		 
		 DAOLogin loginDao = new DAOLogin();
		 
		 String userlogin;
		try {
			userlogin = loginDao.loginUser(loginBean);
			if(userlogin.equals("INVALID EMAIL")) {
				request.setAttribute("errMessage", userlogin);
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			 } else if (userlogin.equals("WRONG PASSWORD")) {
				 request.setAttribute("errMessage", userlogin);
				 request.getRequestDispatcher("/Login.jsp").forward(request, response);
			 } else if (userlogin.equals("Candidate")) {
				 DAOIntro.uType = "Candidate";
				 System.out.println("Candidate");
				 request.getRequestDispatcher("/CandidateServlet").forward(request, response);
			 } else {
			 	 System.out.println("failure");
				 request.setAttribute("errMessage", userlogin);
				 request.getRequestDispatcher("/Login.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
