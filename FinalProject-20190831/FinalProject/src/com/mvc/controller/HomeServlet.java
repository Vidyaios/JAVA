package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Register;
import com.mvc.dao.DAOHome;

public class HomeServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("home profile details called");
        RequestDispatcher dispatcher;
		DAOHome homeDao = new DAOHome();
		try {
	        Register reg = homeDao.getHomeUserDetails();
	        System.out.println("home profile details called");
	        request.setAttribute("profile", reg);
//	        p_username = reg.getUsername();
//	        p_password = reg.getPassword();
//	        p_email = reg.getEmail();
//	        p_type = reg.getType();

//	        dispatcher = request.getRequestDispatcher("/ViewProfile.jsp");
//	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
