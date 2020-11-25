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
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAOLogout;

public class IntroServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public IntroServlet() {
	 }
	 
//	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 		 		 
//		 DAOLogout loginDao = new DAOLogout();
//		 String strIntro;
//		try {
//			strIntro = loginDao.logoutUser();
//			if(strIntro.equals("Candidate")) {
//				request.getRequestDispatcher("HomeCandidate.jsp").forward(request, response);
//			 } else if (strIntro.equals("Company")) {
//					request.getRequestDispatcher("HomeCompany.jsp").forward(request, response);
//			 } else {
//			 	 System.out.println("failure");
//				 request.setAttribute("errMessage", strIntro);
//			 }
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	 }

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("intro post method job called");
        DAOCompany cdao = new DAOCompany();
        List<Job> jList = cdao.getAllJobs();
		System.out.println("job list ==" +jList);
		DAOIntro.uType = "Intro"; 
		request.setAttribute("jobs", jList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Intro.jsp");
		dispatcher.forward(request, response);

    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("intro get method job called");
        DAOCompany cdao = new DAOCompany();
        List<Job> jList = cdao.getAllJobs();
        DAOIntro.uType = "Intro"; 
		System.out.println("job list ==" +jList);
		request.setAttribute("jobs", jList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Intro.jsp");
		dispatcher.forward(request, response);

    }
}
