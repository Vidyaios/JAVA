package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mvc.bean.Job;
import com.mvc.bean.Register;
 import com.mvc.util.DBConnection;

public class DAOEmployeeList {
	public List<Register> getEmployeeList() throws ClassNotFoundException {
		ArrayList<Register> empList = new ArrayList<Register>();
		try(Connection conn = DBConnection.createConnection()) {
		     String sql = "SELECT id,USERNAME from userregister";
		     System.out.println("employee list called == " +sql);
		     Statement st = conn.createStatement();
		     ResultSet result = st.executeQuery(sql);
		     while (result.next()) {
		    	Register reg = new Register();
		    	reg.setuID(result.getString(1));
		        reg.setUsername(result.getString(2));
		        System.out.println("employeee == " +result.getString(1));
		        empList.add(reg);
		     }
		  } catch (SQLException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } catch (ClassNotFoundException ex) {
		      Logger.getLogger(DAOViewProfile.class.getName()).log(Level.SEVERE, null, ex);
		  } 
		return empList;
	}
	
	public List<Register> getFilteredEmpList(String fEmpName) {
        ArrayList<Register> euList = new ArrayList<Register>();
        try(Connection conn = DBConnection.createConnection()) {
            String sql = "select username "
            		+ "from userregister ur join usercv ucv "
            		+ "on(ur.id = ucv.cv_userid) "
            		+ "where name like '%"+fEmpName+"%' or "
            		+ "skills like '%"+fEmpName+"%' or "
            		+ "skills2 like '%"+fEmpName+"%' or "
            		+ "skills3 like '%"+fEmpName+"%' or "
            		+ "skills4 like '%"+fEmpName+"%'";
            System.out.println("filter sql query == " +sql);
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            while(result.next()){
                Register uname = new Register();
                uname.setUsername(result.getString(1));
                euList.add(uname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCompany.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOCompany.class.getName()).log(Level.SEVERE, null, ex);
        }
        return euList;      
    }
}

//select USERNAME  
//from userregister ur join usercv ucv
//on (ur.id = ucv.cv_userid)
//where name like '%p%' or skills like '%p%' or skills2 like '%p%' or skills3 like '%p%' skills4 like '%p%';

