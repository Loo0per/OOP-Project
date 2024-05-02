package com.report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;




public class ReportInsertutil {
public static boolean insertreport(int id, String name, double attendance, double marks, String grade) {
    	
    	boolean isSuccess = false;
    	
    	//DB connection
    	
    	String url = "jdbc:mysql://localhost:3306/osims";
    	String userName = "root";
    	String password = "Root12345";
    	
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con = DriverManager.getConnection(url, userName, password);
    		Statement stmt = con.createStatement();
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
