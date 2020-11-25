package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Job;
import com.mvc.bean.Register;
import com.mvc.dao.DAOCompany;
import com.mvc.dao.DAOCreateJob;
import com.mvc.dao.DAOEmployeeList;
import com.mvc.dao.DAOViewProfile;

public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeListServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("employee list called");
        RequestDispatcher dispatcher;
		DAOEmployeeList eListDao = new DAOEmployeeList();
		try {
	        List<Register> jList = eListDao.getEmployeeList();
	        System.out.println("employee list called");
	        request.setAttribute("eList", jList);
	        dispatcher = request.getRequestDispatcher("/EmployeeList.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empName = request.getParameter("empname");
		System.out.println("filter letter == " +empName);
		
		 DAOEmployeeList empListDao = new DAOEmployeeList();
		 List<Register> eList = empListDao.getFilteredEmpList(empName);
		 System.out.println("filtered emp list ==" +eList);
		 request.setAttribute("eList", eList);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/EmployeeList.jsp");
		 dispatcher.forward(request, response);

	}
}

