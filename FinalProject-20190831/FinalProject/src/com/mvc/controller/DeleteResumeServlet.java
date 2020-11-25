package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Resume;
import com.mvc.dao.DAOCreateResume;
import com.mvc.dao.DAODeleteResume;

public class DeleteResumeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public DeleteResumeServlet() {
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		 		 
		 DAODeleteResume deleteResumeDao = new DAODeleteResume();
		 System.out.println("delete resume called");
		 String resumeDelete;
		try {
			resumeDelete = deleteResumeDao.userResumeDelete();
			if(resumeDelete.equals("SUCCESS")) {
				request.setAttribute("errMessage", resumeDelete);
				request.getRequestDispatcher("/CreateResume.jsp").forward(request, response);
			 } else {
			 	 System.out.println("failure");
				 request.setAttribute("errMessage", resumeDelete);
				 request.getRequestDispatcher("/DeleteResume.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("get method called");
			RequestDispatcher dispatcher;
			DAOCreateResume createDAO = new DAOCreateResume();
			try {
		        Resume resume = createDAO.getResumeDetails();
		        System.out.println("resume details called");
		        request.setAttribute("resume", resume);
		        if(resume.getRname() == null) {
			        dispatcher = request.getRequestDispatcher("/NoResume.jsp");
		        } else {
			        dispatcher = request.getRequestDispatcher("/DeleteResume.jsp");
		        }
		        dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

	    }
}
