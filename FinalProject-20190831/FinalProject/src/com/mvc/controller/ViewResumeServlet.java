package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Resume;
import com.mvc.dao.DAOCreateResume;

public class ViewResumeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewResumeServlet() {
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("view resume get method called");
		RequestDispatcher dispatcher;
		DAOCreateResume createDAO = new DAOCreateResume();
		try {
	        Resume resume = createDAO.getResumeDetails();
	        System.out.println("view resume details called");
	        request.setAttribute("resume", resume);
	        if(resume.getRname() == null) {
		        dispatcher = request.getRequestDispatcher("/NoResume.jsp");
	        } else {
		        dispatcher = request.getRequestDispatcher("/ViewResume.jsp");
	        }
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("view resume post method called");
		RequestDispatcher dispatcher;
		DAOCreateResume createDAO = new DAOCreateResume();
		try {
	        Resume resume = createDAO.getResumeDetails();
	        System.out.println("view resume details called");
	        request.setAttribute("resume", resume);
	        if(resume.getRname() == null) {
		        dispatcher = request.getRequestDispatcher("/NoResume.jsp");
	        } else {
		        dispatcher = request.getRequestDispatcher("/ViewResume.jsp");
	        }
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
