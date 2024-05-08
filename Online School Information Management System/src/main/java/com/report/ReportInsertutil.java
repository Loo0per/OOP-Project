package com.report;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;




public class ReportInsertutil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	
	public static boolean insertreport(int id, String name, double attendance, double marks, String grade) {
	    	
	    	boolean isSuccess = false;
	    	
	    	//DB connection

	    	
	    	try {
	    		con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    	    String sql = "insert into report values ('"+id+"','"+name+"','"+attendance+"','"+marks+"','"+grade+"')";
	    		int result = stmt.executeUpdate(sql);
	    		
	    		if(result > 0) {
	    			isSuccess = true;
	    		} else {
	    			isSuccess = false;
	    		}
	    		
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
	 	
	    	return isSuccess;
	    }

}
