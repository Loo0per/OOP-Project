package com.report;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



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
        	
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	
        
        
	}

}
