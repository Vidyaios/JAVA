package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Job;
import com.mvc.dao.DAOCompany;

public class CandidateServlet extends HttpServlet{
    /**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public CandidateServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get method job called");
        DAOCompany cdao = new DAOCompany();
        List<Job> jList = cdao.getAllJobs();
		System.out.println("job list ==" +jList);
		request.setAttribute("jobs", jList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeCandidate.jsp");
		dispatcher.forward(request, response);

    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get method job called");
        DAOCompany cdao = new DAOCompany();
        List<Job> jList = cdao.getAllJobs();
		System.out.println("job list ==" +jList);
		request.setAttribute("jobs", jList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeCandidate.jsp");
		dispatcher.forward(request, response);

    }
}
