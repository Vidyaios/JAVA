package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Register;
import com.mvc.dao.DAOEditProfile;
import com.mvc.dao.DAOViewProfile;

public class EditProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public EditProfileServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		 String password = request.getParameter("password");
		 String email = request.getParameter("email");
		 String type = request.getParameter("type");
		 
		 Register edituserBean = new Register();
		 edituserBean.setUsername(username);
		 edituserBean.setPassword(password); 
		 edituserBean.setEmail(email);
		 edituserBean.setType(type);;
		 		 
		 DAOEditProfile edituserDao = new DAOEditProfile();
		 
		 String edituser;
		try {
			edituser = edituserDao.editUserProfile(edituserBean);
			if(edituserBean.equals("SUCCESS")) {
				request.setAttribute("errMessage", "Updated Successfully");
				request.getRequestDispatcher("/EditProfile.jsp").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", edituser);
				 request.getRequestDispatcher("/EditProfile.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get profile details called");
        RequestDispatcher dispatcher;
		DAOViewProfile viewDao = new DAOViewProfile();
		try {
	        Register reg = viewDao.getUserDetails();
	        System.out.println("profile details called");
	        request.setAttribute("profile", reg);
	        dispatcher = request.getRequestDispatcher("/EditProfile.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}
