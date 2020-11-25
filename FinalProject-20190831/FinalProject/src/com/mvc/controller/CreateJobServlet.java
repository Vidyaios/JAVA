package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Job;
import com.mvc.bean.Register;
import com.mvc.dao.DAOCreateJob;
import com.mvc.dao.DAOIntro;
import com.mvc.dao.DAORegister;

public class CreateJobServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	 public CreateJobServlet() {
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		 
		 
		 DAOCreateJob createJobDao = new DAOCreateJob();
		 
		 String createJob;
		try {
			createJob = createJobDao.createUserJob(jobBean);
			if(createJob.equals("SUCCESS")) {
				 System.out.println("Success");
//				 request.getRequestDispatcher("/HomeCompany.jsp").forward(request, response);
				 request.getRequestDispatcher("/CompanyServlet").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", createJob);
				 request.getRequestDispatcher("/CreateJob.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 }
}
