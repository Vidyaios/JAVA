package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.CRegister;
import com.mvc.dao.DAOViewCProfile;

public class ViewCprofileServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public ViewCprofileServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("company profile details called");
        RequestDispatcher dispatcher;
		DAOViewCProfile viewCDao = new DAOViewCProfile();
		try {
	        CRegister reg = viewCDao.getCompanyDetails();
	        System.out.println("company profile details called");
	        request.setAttribute("cprofile", reg);
	        dispatcher = request.getRequestDispatcher("/ViewCProfile.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
