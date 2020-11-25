package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Resume;
import com.mvc.dao.DAOViewResCompany;

public class ViewResCompanyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewResCompanyServlet() {
	}
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get view job details called");
        System.out.println("job id == " +request.getParameter("userid"));
        String uid = request.getParameter("userid");

		System.out.println("view resume method called");
		RequestDispatcher dispatcher;
		DAOViewResCompany viewResDAO = new DAOViewResCompany();
		try {
	        Resume resume = viewResDAO.getEmpResumeDetails(uid);
	        System.out.println("view resume details called");
	        request.setAttribute("resume", resume);
	        System.out.println("resume name " +resume.getRname());
	        if(resume.getRname() == null) {
		        dispatcher = request.getRequestDispatcher("/NoResumeCompany.jsp");
	        } else {
		        dispatcher = request.getRequestDispatcher("/ViewResumeCompany.jsp");
	        }
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }

}
