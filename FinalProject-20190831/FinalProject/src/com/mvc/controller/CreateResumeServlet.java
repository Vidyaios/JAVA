package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Resume;
import com.mvc.dao.DAOCreateResume;
import com.mvc.dao.DAOIntro;

public class CreateResumeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreateResumeServlet() {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("resume id == " +DAOIntro.userID);
		 System.out.println("post method called");
		 
	 String rname = DAOIntro.global_uname;//request.getParameter("name");
	 String remailid = request.getParameter("email");	
	 String rmobilenumber = request.getParameter("mnumber");
	 String total_workexp_year = request.getParameter("expyear");
	 String total_workexp_month = request.getParameter("expmonth");
	 String currentDesi = request.getParameter("currDesc");
	 String currentCompany = request.getParameter("currComp");
	 String annualsalary_lakhs = request.getParameter("annSalLakh");
	 String annualsalary_tho = request.getParameter("annSalThousand");
	 String workingfromyear = request.getParameter("workFromYear");
	 String workingfrommonth = request.getParameter("workFromMonth");
	 String workingtomonth = request.getParameter("workToYear");
	 String workingtoyear = request.getParameter("workToMonth");
	 String currentlocaton = request.getParameter("currLocation");
	 String noticeperiod = request.getParameter("notice");
	 String skills = request.getParameter("skills1");
	 String industry = request.getParameter("industry");
	 String functionalArea = request.getParameter("funcArea");
	 String role = request.getParameter("role");
	 String highestEdu = request.getParameter("highestEdu");
	 String course = request.getParameter("course");
	 String specialization = request.getParameter("spe");
	 String university = request.getParameter("college");
	 String coursetype = request.getParameter("courseType");
	 String passingyear = request.getParameter("passyear");
	 String skills2 = request.getParameter("skills2");
	 String skills3= request.getParameter("skills3");
	 String skills4 = request.getParameter("skills4");
	 String pDesc = request.getParameter("pdesc");
	 String pcomp = request.getParameter("pcomp");
	 String pworkingfromyear = request.getParameter("pworkFromYear");
	 String pworkingfrommonth = request.getParameter("pworkFromMonth");
	 String pworkingtoyear = request.getParameter("pworkToYear");
	 String pworkingtomonth = request.getParameter("pworkToMonth");
	 String puniversity = request.getParameter("pCollege");
	 String pcourse = request.getParameter("pCourse");
	 String ppassingyear = request.getParameter("prepassyear");
	 String lang1 = request.getParameter("lang1");
	 String lang2 = request.getParameter("lang2");
	 String lang3 = request.getParameter("lang3");
	 
	 Resume resumeBean = new Resume();
	 resumeBean.setRname(rname);
	 resumeBean.setRemailid(remailid);
	 resumeBean.setRmobilenumber(rmobilenumber);
	 resumeBean.setTotal_workexp_year(total_workexp_year);
	 resumeBean.setTotal_workexp_month(total_workexp_month);
	 resumeBean.setCurrentDesi(currentDesi);
	 resumeBean.setCurrentCompany(currentCompany);
	 resumeBean.setAnnualsalary_lakhs(annualsalary_lakhs);
	 resumeBean.setAnnualsalary_tho(annualsalary_tho);
	 resumeBean.setCurrentlocaton(currentlocaton);
	 resumeBean.setNoticeperiod(noticeperiod);
	 resumeBean.setSkills(skills);
	 resumeBean.setIndustry(industry);
	 resumeBean.setFunctionalArea(functionalArea);
	 resumeBean.setRole(role);
	 resumeBean.setHighestEdu(highestEdu);
	 resumeBean.setCourse(course);
	 resumeBean.setSpecialization(specialization);
	 resumeBean.setUniversity(university);
	 resumeBean.setCoursetype(coursetype);
	 resumeBean.setPassingyear(passingyear);
	 resumeBean.setWorkingfromyear(workingfromyear);
	 resumeBean.setWorkingfrommonth(workingfrommonth);
	 resumeBean.setWorkingtoyear(workingtoyear);
	 resumeBean.setWorkingtomonth(workingtomonth);
	 resumeBean.setSkill2(skills2);
	 resumeBean.setSkill3(skills3);
	 resumeBean.setSkill4(skills4);
	 resumeBean.setPre_comDesc(pDesc);
	 resumeBean.setPre_company(pcomp);
	 resumeBean.setP_fromyear(pworkingfromyear);
	 resumeBean.setP_fromyear(pworkingfrommonth);
	 resumeBean.setP_toyear(pworkingtoyear);
	 resumeBean.setP_tomonth(pworkingtomonth);
	 resumeBean.setP_university(puniversity);
	 resumeBean.setP_degree(pcourse);
	 resumeBean.setP_degreeYear(ppassingyear);
	 resumeBean.setLang1(lang1);
	 resumeBean.setLang2(lang2);
	 resumeBean.setLang3(lang3);
	 
	 
	 DAOCreateResume crDAO = new DAOCreateResume();
	 
	 String userResume;
	 try {
		 userResume = crDAO.userResume(resumeBean);
			if(userResume.equals("SUCCESS")) {
				request.setAttribute("errMessage", userResume);
				request.getRequestDispatcher("/ViewResumeServlet").forward(request, response);
			 } else {
				 System.out.println("failure");
				 request.setAttribute("errMessage", userResume);
				 request.getRequestDispatcher("/CreateResume.jsp").forward(request, response);
			 }
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get resume method called - create");
		RequestDispatcher dispatcher;
		DAOCreateResume createDAO = new DAOCreateResume();
		try {
	        Resume resume = createDAO.getResumeDetails();
	        System.out.println("resume details called");
	        request.setAttribute("resume", resume);
	        dispatcher = request.getRequestDispatcher("/CreateResume.jsp");
	        dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

    }
}


