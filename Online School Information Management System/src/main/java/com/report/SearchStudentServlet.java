package com.report;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int studentId = Integer.parseInt(request.getParameter("studentId"));
		 PrintWriter out = response.getWriter();
	        // Retrieve the student details from the database
		 	StudentResult student = ReportDBUtil.getStudentById(studentId);

		 	request.setAttribute("student", student);
	
	        if (student != null) {
	        	request.getRequestDispatcher("searchstudent.jsp").forward(request, response);
	        }
	        else {
	        	out.println("<h1>Student Not Found</h1>");
	        }
	      
	}

}
