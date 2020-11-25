package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.DAODeleteJob;
import com.mvc.dao.DAOLogout;

public class DeleteJobServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public DeleteJobServlet() {
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		 		 
		 DAODeleteJob deleteDao = new DAODeleteJob();
		 System.out.println("delete job called");
		 String jobDelete;
		try {
			jobDelete = deleteDao.userJobDelete();
			if(jobDelete.equals("SUCCESS")) {
				request.setAttribute("errMessage", jobDelete);
				request.getRequestDispatcher("/CompanyServlet").forward(request, response);
			 } else {
			 	 System.out.println("failure");
				 request.setAttribute("errMessage", jobDelete);
				 request.getRequestDispatcher("/ViewJob.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
