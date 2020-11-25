package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Job;
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAOViewJob;


public class ViewJobServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ViewJobServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get view job details called");
        System.out.println("job id == " +request.getParameter("jid"));
        String id = request.getParameter("jid");
        
        RequestDispatcher dispatcher;
		DAOViewJob viewJDao = new DAOViewJob();
		try {
	        Job jBean = viewJDao.getJobDetails(id);
	        System.out.println("view job called");
	        request.setAttribute("jView", jBean);
	        System.out.println("user type == " +DAOIntro.uType);
	        if (DAOIntro.uType.equals("Candidate")) {
		        dispatcher = request.getRequestDispatcher("/ViewCandidateJob.jsp");
	        } else if (DAOIntro.uType.equals("Company")){
		        dispatcher = request.getRequestDispatcher("/ViewJob.jsp");
	        } else {
	        	dispatcher = request.getRequestDispatcher("/ViewIntroJob.jsp");
	        }
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post view job details called");
        System.out.println("job id == " +DAOIntro.global_jobID);
        String id = DAOIntro.global_jobID;
        
        RequestDispatcher dispatcher;
		DAOViewJob viewJDao = new DAOViewJob();
		try {
	        Job jBean = viewJDao.getJobDetails(id);
	        System.out.println("view job called");
	        request.setAttribute("jView", jBean);
	        System.out.println("user type == " +DAOIntro.uType);
	        if (DAOIntro.uType.equals("Candidate")) {
		        dispatcher = request.getRequestDispatcher("/ViewCandidateJob.jsp");
	        } else if (DAOIntro.uType.equals("Company")){
		        dispatcher = request.getRequestDispatcher("/ViewJob.jsp");
	        } else {
	        	dispatcher = request.getRequestDispatcher("/ViewIntroJob.jsp");
	        }
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
