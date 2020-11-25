package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.DAOLogout;

public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		 		 
		 DAOLogout loginDao = new DAOLogout();
		 System.out.println("logout called");
		 String userlogout;
		try {
			userlogout = loginDao.logoutUser();
			if(userlogout.equals("SUCCESS")) {
				request.setAttribute("errMessage", userlogout);
				request.getRequestDispatcher("/IntroServlet").forward(request, response);
			 } else {
			 	 System.out.println("failure");
				 request.setAttribute("errMessage", userlogout);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
