package com.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        int attendance = Integer.parseInt(request.getParameter("attendance"));
        int marks = Integer.parseInt(request.getParameter("marks"));
        double totalPercentage = (attendance * 0.1) + (marks * 0.9);
        String grade = Grade.calculateGrade(totalPercentage);

        // Create a Student object
        StudentResult student = new StudentResult(studentId, name, attendance, marks, grade);

        // Update the student details in the database
        boolean updated = ReportDBUtil.updateStudent(student);

        // Set the response content type
        response.setContentType("text/html");


        PrintWriter out = response.getWriter();

        // Write the response
        out.println("<html><body>");
        if (updated) {
        	out.println("<script type=\"text/javascript\">"); 
        	out.println("alert(' "+studentId+" Student Details Updated Successfully');window.location.reload();"); 
        	out.println("location='searchstudent.jsp';"); 
        	out.println("</script>");
        } else {
            out.println("<h1>Failed to Update Student Details</h1>");
        }
        out.println("</body></html>");
    }

    

}
