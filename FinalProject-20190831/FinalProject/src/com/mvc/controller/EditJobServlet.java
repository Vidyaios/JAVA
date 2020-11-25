package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Job;
import com.mvc.dao.DAOEditJob;

public class EditJobServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public EditJobServlet() {
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String jobTitle = request.getParameter("title");
		 String jDesc = request.getParameter("jdesc");
		 String salary = request.getParameter("salary");
		 String jobType = request.getParameter("jType");
		 String jSkills = request.getParameter("skills");
		 String jcompanyName = request.getParameter("cName");
		 String jcompDesc = request.getParameter("cDesc");
		 String jcity = request.getParameter("city");
		 String creationDate = request.getParameter("jCDate");
		 String endDate = request.getParameter("jEDate");
		 String experience = request.getParameter("jExp");
		 String jobRole = request.getParameter("role");
		 String jIndustryType = request.getParameter("jIndusType");
		 String jFuncArea = request.getParameter("jFuncArea");
		 String jEducation = request.getParameter("jEdu");
		 String jContactPerson = request.getParameter("jCPerson");
		 
		 
		 Job jobBean = new Job();
		 jobBean.setJobTitle(jobTitle);
		 jobBean.setDescription(jDesc);
		 jobBean.setSalary(salary);
		 jobBean.setJobType(jobType);
		 jobBean.setjSkills(jSkills);
		 jobBean.setCompanyName(jcompanyName);
		 jobBean.setCompDesc(jcompDesc);
		 jobBean.setCity(jcity);
		 jobBean.setCreationDate(creationDate);
		 jobBean.setEndDate(endDate);
		 jobBean.setExperience(experience);
		 jobBean.setJobRole(jobRole);
		 jobBean.setjIndustryType(jIndustryType);
		 jobBean.setjFuncArea(jFuncArea);
		 jobBean.setjEducation(jEducation);
		 jobBean.setjContactPerson(jContactPerson);
		 
		 
		 DAOEditJob createJobDao = new DAOEditJob();
		 
		 String editJob;
		try {
			editJob = createJobDao.editUserJob(jobBean);
			if(editJob.equals("SUCCESS")) {
				 System.out.println("Success");
				 request.setAttribute("errMessage", "Updated Successfully");
				 request.getRequestDispatcher("/ViewJobServlet").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", editJob);
				 request.getRequestDispatcher("/EditJob.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
