package com.mvc.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.Register;
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAORegister;

public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 String email = request.getParameter("email");
		 String type = request.getParameter("type");
		 
		 Register registerBean = new Register();
		 registerBean.setUsername(username);
		 registerBean.setPassword(password); 
		 registerBean.setEmail(email);
		 registerBean.setType(type);
		 		 
		 DAORegister registerDao = new DAORegister();
		 
		 String userRegistered;
		try {
			userRegistered = registerDao.registerUser(registerBean);
			if(userRegistered.equals("ALREADY REGISTERED")) {
				request.setAttribute("errMessage", "User Already Registered. Please try a different email.");
				request.getRequestDispatcher("/Register.jsp").forward(request, response);
			 } else if (userRegistered.equals("SUCCESS")) {
				 DAOIntro.uType = "Candidate";
				 System.out.println("Success");
				 System.out.println("Candidate");
				 request.getRequestDispatcher("/CandidateServlet").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", userRegistered);
				 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
