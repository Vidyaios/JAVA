package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.Resume;
import com.mvc.util.DBConnection;

public class DAOViewResCompany {
public Resume getEmpResumeDetails(String userResID) throws ClassNotFoundException {
		
	Connection connection = null;
	try {
		 connection = DBConnection.createConnection();
		 System.out.println("user resume");
	     Statement st = connection.createStatement();
		 String query = "select count(*) from usercv where cv_userid = '"+userResID+"'"; 
         ResultSet result1 = st.executeQuery(query);
         result1.next();
         
         String strCount = result1.getString(1);
         System.out.println("count = " +strCount);
         if(strCount.equals("0")) {
        	 Resume res = new Resume();
		     System.out.println("resume details called == " +res);
        	 return res;
         } else {
		     String sql = "SELECT name,emailid,mobilenumber,total_workexp_year,total_workexp_month,currentDesi,currentCompany,annualsalary_lakhs,annualsalary_tho,workingfrom_year,"
			     		+ "workingfrom_month,currentlocaton,noticeperiod,skills,industry,functionalArea,role,highestEdu,course,specialization,"
			     		+ "university,coursetype,passingyear,workingto_year,workingto_month,skills2,skills3,skills4,p_company,p_desc,"
			     		+ "p_fromyear,p_frommonth,p_toyear,p_tomonth,p_degree,p_university,p_degreeYear,lang1,lang2,lang3 from usercv where cv_userid = '"+userResID+"' ";
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
			        
			    	DAOCreateResume.r_name = result.getString(1);
			    	DAOCreateResume.r_email = result.getString(2);
			    	DAOCreateResume.r_number = result.getString(3);
			    	DAOCreateResume.r_workexpyear = result.getString(4);
			    	DAOCreateResume.r_workexpmon = result.getString(5);
			    	DAOCreateResume.r_currDesc = result.getString(6);
			    	DAOCreateResume.r_currComp = result.getString(7);
			    	DAOCreateResume.r_salaryL = result.getString(8);
			    	DAOCreateResume.r_salaryT = result.getString(9);
			    	DAOCreateResume.r_workFromYear = result.getString(10);
			    	DAOCreateResume.r_workFromMonth = result.getString(11);
			    	DAOCreateResume.r_currLocation = result.getString(12);
			    	DAOCreateResume.r_noticPeriod = result.getString(13);
			    	DAOCreateResume.r_skills = result.getString(14);
			    	DAOCreateResume.r_indusrty = result.getString(15);
			    	DAOCreateResume.r_funcArea = result.getString(16);
			    	DAOCreateResume.r_role = result.getString(17);
			    	DAOCreateResume.r_highestEdu = result.getString(18);
			    	DAOCreateResume.r_course = result.getString(19);
			    	DAOCreateResume.r_spec = result.getString(20);
			    	DAOCreateResume.r_university = result.getString(21);
			    	DAOCreateResume.r_courseType = result.getString(22);
			    	DAOCreateResume.r_passYear = result.getString(23);
			    	DAOCreateResume.r_workToYear = result.getString(24);
			    	DAOCreateResume.r_workToMonth = result.getString(25); 		
			    	DAOCreateResume.r_skills2 = result.getString(26); 		
			    	DAOCreateResume.r_skills3 = result.getString(27);
			    	DAOCreateResume.r_skills4 = result.getString(28);
			    	DAOCreateResume.r_preCompany = result.getString(29); 
			    	DAOCreateResume.r_preCompDesc = result.getString(30); 
			    	DAOCreateResume.r_preFromYear = result.getString(31); 
			    	DAOCreateResume.r_preFromMonth = result.getString(32); 
			    	DAOCreateResume.r_preToYear = result.getString(33); 
			    	DAOCreateResume.r_preToMonth = result.getString(34); 
			    	DAOCreateResume.r_prevDegree = result.getString(35); 
			    	DAOCreateResume.r_prevUniversity = result.getString(36); 
			    	DAOCreateResume.r_prePassYear = result.getString(37); 
			    	DAOCreateResume.r_lang1 = result.getString(38); 
			    	DAOCreateResume.r_lang2 = result.getString(39); 
			    	DAOCreateResume.r_lang3 = result.getString(40); 
			    			    	
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
