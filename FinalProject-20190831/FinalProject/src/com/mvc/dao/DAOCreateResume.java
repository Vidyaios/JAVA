package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.CRegister;
import com.mvc.bean.Resume;
import com.mvc.util.DBConnection;

public class DAOCreateResume {
	public static String r_name = "", r_email = "", r_number = "", r_workexpyear = "", r_workexpmon = "", r_currDesc = "", r_currComp = "", r_salaryL = "", 
		r_salaryT = "", r_workFromYear = "", r_workFromMonth = "", r_currLocation ="", r_noticPeriod = "", r_skills = "", r_indusrty = "",
		r_funcArea = "", r_role = "", r_highestEdu = "", r_course = "", r_spec = "", r_university = "", r_courseType = "", r_passYear = "",
		r_workToYear = "", r_workToMonth = "", r_skills2 = "", r_skills3 = "", r_skills4 = "", r_preCompany = "", r_preCompDesc = "", r_preFromYear = "",
		r_preFromMonth = "", r_preToYear = "", r_preToMonth = "", r_prevDegree = "", r_prevUniversity = "", r_prePassYear = "", r_lang1 = "",
		r_lang2 = "", r_lang3 = "";
	
	
	public String userResume(Resume resumeBean) throws ClassNotFoundException
	 {		
		 String rname = resumeBean.getRname();
		 String remailid = resumeBean.getRemailid();
		 String rmobilenumber = resumeBean.getRmobilenumber();
		 String total_workexp_year = resumeBean.getTotal_workexp_year();
		 String total_workexp_month = resumeBean.getTotal_workexp_month();
		 String currentDesi = resumeBean.getCurrentDesi();
		 String currentCompany = resumeBean.getCurrentCompany();
		 String annualsalary_lakhs = resumeBean.getAnnualsalary_lakhs();
		 String annualsalary_tho = resumeBean.getAnnualsalary_tho();
		 String workingfromyear  = resumeBean.getWorkingfromyear();
		 String workingfrommonth  = resumeBean.getWorkingfrommonth();
		 String workingtomonth = resumeBean.getWorkingtoyear();
		 String workingtoyear = resumeBean.getWorkingtomonth();
		 String currentlocaton = resumeBean.getCurrentlocaton();
		 String noticeperiod = resumeBean.getNoticeperiod();
		 String skills = resumeBean.getSkills();
		 String industry = resumeBean.getIndustry();
		 String functionalArea = resumeBean.getFunctionalArea();
		 String role = resumeBean.getRole();
		 String highestEdu = resumeBean.getHighestEdu();
		 String course = resumeBean.getCourse();
		 String specialization = resumeBean.getSpecialization();
		 String university = resumeBean.getUniversity();
		 String coursetype = resumeBean.getCoursetype();
		 String passingyear = resumeBean.getPassingyear();
		 String skills2 = resumeBean.getSkill2();
		 String skills3= resumeBean.getSkill3();
		 String skills4 = resumeBean.getSkill4();
		 String pDesc = resumeBean.getPre_comDesc();
		 String pcomp = resumeBean.getPre_company();
		 String pworkingfromyear = resumeBean.getP_fromyear();
		 String pworkingfrommonth = resumeBean.getP_frommonth();
		 String pworkingtoyear = resumeBean.getP_toyear();
		 String pworkingtomonth = resumeBean.getP_tomonth();
		 String puniversity = resumeBean.getP_university();
		 String pcourse = resumeBean.getP_degree();
		 String ppassingyear = resumeBean.getP_degreeYear();
		 String lang1 = resumeBean.getLang1();
		 String lang2 = resumeBean.getLang2();
		 String lang3 = resumeBean.getLang3();		 
		 
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try {
			 con = DBConnection.createConnection();
			 System.out.println("userRegistered2");
			 Statement st = con.createStatement();
			 String query = "select count(*) from usercv where cv_userid = '"+DAOIntro.userID+"'"; 
	         ResultSet result = st.executeQuery(query);
	         result.next();
	         
	         String strCount = result.getString(1);
	         System.out.println("count = " +strCount);
	         String query1;
	         if(strCount.equals("0")) {
	        	 query1 = "insert into usercv values (RESUMESEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	         } else {
	        	 query1 = "update usercv set cv_userid = ?,name = ?, emailid = ?, mobilenumber = ?, total_workexp_year = ?, total_workexp_month = ?, currentDesi = ?, currentCompany = ?, "
	        	 		+ "annualsalary_lakhs = ?, annualsalary_tho = ?, workingfrom_year = ?, workingfrom_month = ?, workingto_year = ?, workingto_month = ?, currentlocaton = ?, noticeperiod = ?, skills = ?, industry = ?, "
	        	 		+ "functionalArea = ?, role = ?, highestEdu = ?, course = ?, specialization = ?, university = ?, coursetype = ?, passingyear = ?, skills2 = ?, skills3 = ?, skills4 = ?,"
	        	 		+ "p_company = ?, p_desc = ?, p_fromyear = ?, p_frommonth = ?, p_toyear = ?, p_tomonth = ?, p_degree = ?, p_university = ?, p_degreeStart = ?, p_degreeEnd = ?,"
	        	 		+ "lang1 = ?, lang2 = ?, lang3 = ?  where cv_userid = '"+DAOIntro.userID+"'"; 
	         }
				 preparedStatement = con.prepareStatement(query1);
				 preparedStatement.setString(1, DAOIntro.userID);
				 preparedStatement.setString(2, rname);
				 preparedStatement.setString(3, remailid);
				 preparedStatement.setString(4, rmobilenumber);
				 preparedStatement.setString(5, total_workexp_year);
				 preparedStatement.setString(6, total_workexp_month);
				 preparedStatement.setString(7, currentDesi);
				 preparedStatement.setString(8, currentCompany);
				 preparedStatement.setString(9, annualsalary_lakhs);
				 preparedStatement.setString(10, annualsalary_tho);
				 preparedStatement.setString(11, workingfromyear);
				 preparedStatement.setString(12, workingfrommonth);
				 preparedStatement.setString(13, workingtomonth);
				 preparedStatement.setString(14, workingtoyear);
				 preparedStatement.setString(15, currentlocaton);
				 preparedStatement.setString(16, noticeperiod);
				 preparedStatement.setString(17, skills);
				 preparedStatement.setString(18, industry);
				 preparedStatement.setString(19, functionalArea);
				 preparedStatement.setString(20, role);
				 preparedStatement.setString(21, highestEdu);
				 preparedStatement.setString(22, course);
				 preparedStatement.setString(23, specialization);
				 preparedStatement.setString(24, university);
				 preparedStatement.setString(25, coursetype);
				 preparedStatement.setString(26, passingyear);
				 preparedStatement.setString(27, skills2);
				 preparedStatement.setString(28, skills3);
				 preparedStatement.setString(29, skills4);
				 preparedStatement.setString(30, pDesc);
				 preparedStatement.setString(31, pcomp);
				 preparedStatement.setString(32, pworkingfromyear);
				 preparedStatement.setString(33, pworkingfrommonth);
				 preparedStatement.setString(34, pworkingtoyear);
				 preparedStatement.setString(35, pworkingtomonth);
				 preparedStatement.setString(36, puniversity);
				 preparedStatement.setString(37, pcourse);
				 preparedStatement.setString(38, ppassingyear);
				 preparedStatement.setString(39, lang1);
				 preparedStatement.setString(40, lang2);
				 preparedStatement.setString(41, lang3);
				 
				 
				 int i= preparedStatement.executeUpdate();
				 if (i!=0) {
					 return "SUCCESS"; 
				 }
	         
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } catch(NullPointerException e) { 
	         System.out.print("NullPointerException Caught"); 
	     } 
		 return "Oops.. Something went wrong there..!";  
	 }
	
	

public Resume getResumeDetails() throws ClassNotFoundException {
		
		Connection connection = null;
		try {
			 connection = DBConnection.createConnection();
			 System.out.println("user resume");
		     Statement st = connection.createStatement();
			 String query = "select count(*) from usercv where cv_userid = '"+DAOIntro.userID+"'"; 
	         ResultSet result1 = st.executeQuery(query);
	         result1.next();
	         
	         String strCount = result1.getString(1);
	         System.out.println("count = " +strCount);
	         if(strCount.equals("0")) {
	        	 Resume res = new Resume();
	        	 return res;
	         } else {
			     String sql = "SELECT name,emailid,mobilenumber,total_workexp_year,total_workexp_month,currentDesi,currentCompany,annualsalary_lakhs,annualsalary_tho,workingfrom_year,"
				     		+ "workingfrom_month,currentlocaton,noticeperiod,skills,industry,functionalArea,role,highestEdu,course,specialization,"
				     		+ "university,coursetype,passingyear,workingto_year,workingto_month,skills2,skills3,skills4,p_company,p_desc,"
				     		+ "p_fromyear,p_frommonth,p_toyear,p_tomonth,p_degree,p_university,p_degreeYear,lang1,lang2,lang3 from usercv where cv_userid = '"+DAOIntro.userID+"' ";
				     System.out.println("company profile details called == " +sql);
				     ResultSet result = st.executeQuery(sql);
				     if (result.next()) {
				        Resume res = new Resume();
				        res.setRname(result.getString(1));
				        res.setRemailid(result.getString(2)); 
				        res.setRmobilenumber(result.getString(3));
				        res.setTotal_workexp_year(result.getString(4));
				        res.setTotal_workexp_month(result.getString(5));
				        res.setCurrentDesi(result.getString(6));
				        res.setCurrentCompany(result.getString(7));
				        res.setAnnualsalary_lakhs(result.getString(8));
				        res.setAnnualsalary_tho(result.getString(9));
				        res.setWorkingfromyear(result.getString(10));
				        res.setWorkingfrommonth(result.getString(11));
				        res.setCurrentlocaton(result.getString(12));
				        res.setNoticeperiod(result.getString(13));
				        res.setSkills(result.getString(14));
				        res.setIndustry(result.getString(15));
				        res.setFunctionalArea(result.getString(16));
				        res.setRole(result.getString(17));
				        res.setHighestEdu(result.getString(18));
				        res.setCourse(result.getString(19));
				        res.setSpecialization(result.getString(20));
				        res.setUniversity(result.getString(21));
				        res.setCoursetype(result.getString(22));
				        res.setPassingyear(result.getString(23));
				        res.setWorkingtoyear(result.getString(24));
				        res.setWorkingtomonth(result.getString(25));
				        res.setSkill2(result.getString(26));
				        res.setSkill3(result.getString(27));
				        res.setSkill4(result.getString(28));
				        res.setPre_company(result.getString(29));
				        res.setPre_comDesc(result.getString(30));
				        res.setP_fromyear(result.getString(31));
				        res.setP_frommonth(result.getString(32));
				        res.setP_toyear(result.getString(33));
				        res.setP_tomonth(result.getString(34));
				        res.setP_degree(result.getString(35));
				        res.setP_university(result.getString(36));
				        res.setP_degreeYear(result.getString(37));
				        res.setLang1(result.getString(38));
				        res.setLang2(result.getString(39));
				        res.setLang3(result.getString(40));
				        
				    	r_name = result.getString(1);
				    	r_email = result.getString(2);
				    	r_number = result.getString(3);
				    	r_workexpyear = result.getString(4);
				    	r_workexpmon = result.getString(5);
				    	r_currDesc = result.getString(6);
				    	r_currComp = result.getString(7);
				    	r_salaryL = result.getString(8);
				    	r_salaryT = result.getString(9);
				    	r_workFromYear = result.getString(10);
				    	r_workFromMonth = result.getString(11);
				    	r_currLocation = result.getString(12);
				    	r_noticPeriod = result.getString(13);
				    	r_skills = result.getString(14);
				    	r_indusrty = result.getString(15);
				    	r_funcArea = result.getString(16);
				    	r_role = result.getString(17);
				    	r_highestEdu = result.getString(18);
				    	r_course = result.getString(19);
				    	r_spec = result.getString(20);
				    	r_university = result.getString(21);
				    	r_courseType = result.getString(22);
				    	r_passYear = result.getString(23);
				    	r_workToYear = result.getString(24);
				    	r_workToMonth = result.getString(25); 		
				    	r_skills2 = result.getString(26); 		
				    	r_skills3 = result.getString(27);
				    	r_skills4 = result.getString(28);
				    	r_preCompany = result.getString(29); 
				    	r_preCompDesc = result.getString(30); 
				    	r_preFromYear = result.getString(31); 
				    	r_preFromMonth = result.getString(32); 
				    	r_preToYear = result.getString(33); 
				    	r_preToMonth = result.getString(34); 
				    	r_prevDegree = result.getString(35); 
				    	r_prevUniversity = result.getString(36); 
				    	r_prePassYear = result.getString(37); 
				    	r_lang1 = result.getString(38); 
				    	r_lang2 = result.getString(39); 
				    	r_lang3 = result.getString(40); 
				    			    	
				        System.out.println("resume details called == " +res);
				        return res;
 
				     }
		     }
		  } catch (SQLException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } catch (ClassNotFoundException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		  return null;
	}
}
