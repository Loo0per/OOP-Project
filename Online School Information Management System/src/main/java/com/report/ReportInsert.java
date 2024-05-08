package com.report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/ReportInsert")
public class ReportInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("ID"));
		String name = request.getParameter("name");
		double attendance = Double.parseDouble(request.getParameter("att"));
        double marks = Double.parseDouble(request.getParameter("marks"));
        
      
        
        double totalPercentage = (attendance * 0.1) + (marks * 0.9);
        String grade = Grade.calculateGrade(totalPercentage);
      
        boolean isTrue;
        
        isTrue = ReportInsertutil.insertreport(id, name, attendance, marks, grade);
        if(isTrue == true) {
        	
        	PrintWriter out = response.getWriter(); 
        	out.println("<script type=\"text/javascript\">"); 
        	out.println("alert('Success! "+name+"s grade has been generated and recorded');"); 
        	out.println("location='Reportin.jsp';"); 
        	out.println("</script>");
        	
		} else {
			PrintWriter out = response.getWriter(); 
        	out.println("<script type=\"text/javascript\">"); 
        	out.println("alert('Submission failed');"); 
        	out.println("location='Reportin.jsp';"); 
        	out.println("</script>");
		}
		
		
	
        
        
	}

}
