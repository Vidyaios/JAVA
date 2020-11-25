package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Register;
import com.mvc.dao.DAOViewProfile;

@WebServlet()
public class ViewProfileServlet extends HttpServlet {

//	public static String p_username, p_password, p_email, p_type;
	
	private static final long serialVersionUID = 1L;

	public ViewProfileServlet() {
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("profile details called");
        RequestDispatcher dispatcher;
		DAOViewProfile viewDao = new DAOViewProfile();
		try {
	        Register reg = viewDao.getUserDetails();
	        System.out.println("profile details called");
	        request.setAttribute("profile", reg);
//	        p_username = reg.getUsername();
//	        p_password = reg.getPassword();
//	        p_email = reg.getEmail();
//	        p_type = reg.getType();

	        dispatcher = request.getRequestDispatcher("/ViewProfile.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }

}
