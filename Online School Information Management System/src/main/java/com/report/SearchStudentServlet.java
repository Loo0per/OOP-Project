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

	        // Set the response content type
	        response.setContentType("text/html");

	        // Get the PrintWriter object to write the response


	        // Write the response
	        out.println("<html><body>");
	        if (student != null) {
	            out.println("<h1>Student Details</h1>");
	            out.println("<form method='post' action='UpdateStudentServlet'>");
	            out.println("<input type='hidden' name='studentId' value='" + student.getId() + "'>");
	            out.println("<label>Name:</label>");
	            out.println("<input type='text' name='name' value='" + student.getName() + "'><br>");
	            out.println("<label>Attendance:</label>");
	            out.println("<input type='number' name='attendance' min='0' max='100' value='" + student.getAttendance() + "'><br>");
	            out.println("<label>Marks:</label>");
	            out.println("<input type='number' name='marks' min='0' max='100' value='" + student.getMarks() + "'><br>");
	            out.println("<label>Grade:</label>");
	            out.println("<input type='text' name='grade' value='" + student.getGrade() + "' readonly><br>");
	            out.println("<input type='submit' value='Update'>");
	            out.println("</form>");
	            out.println("<form method='post' action='DeleteStudentServlet'>");
	            out.println("<input type='hidden' name='studentId' value='" + student.getId() + "'>");
	            out.println("<input type='submit' value='Delete'>");
	            out.println("</form>");
	        } else {
	            out.println("<h1>Student Not Found</h1>");
	        }
	        out.println("</body></html>");
	}

}
