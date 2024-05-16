package com.report;


import java.sql.*;




public class ReportDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet resultSet = null;
	
	public static boolean insertreport(int id, String name, double attendance, double marks, String grade) {
	    	
	    	boolean isSuccess = false;
	    	
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
	public static StudentResult getStudentById(int studentId) {
    	StudentResult student = null;

        try {  	con = DBconnect.getConnection();
	    		stmt = con.createStatement();
	    		String sql = "select * from report where Student_Id='"+studentId+"'";
            
	    		resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                String name = resultSet.getString("Student_Name");
                int attendance = resultSet.getInt("Attendance");
                int marks = resultSet.getInt("Marks");
                String grade = resultSet.getString("Grade");

                student = new StudentResult(studentId, name, attendance, marks, grade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }
	
	public static boolean updateStudent(StudentResult student) {
        try {	
        	con = DBconnect.getConnection();
	    	stmt = con.createStatement();
            String sql = "UPDATE report SET Student_Name = '"+student.getName()+"', Attendance = '"+student.getAttendance()+"', Marks = '"+student.getMarks()+"', Grade = '"+student.getGrade()+"' WHERE Student_Id = '"+student.getId()+"'";
            int result = stmt.executeUpdate(sql);

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
	
	public static boolean deleteStudent(int studentId) {
	    try { 
	    	con = DBconnect.getConnection();
		    stmt = con.createStatement(); 
	        String sql = "DELETE FROM report WHERE Student_Id='"+studentId+"'";
	        int result = stmt.executeUpdate(sql);

	        return result > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
  
}
