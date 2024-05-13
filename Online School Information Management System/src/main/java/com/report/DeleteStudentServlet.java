package com.report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));

        // Delete the student from the database
        boolean deleted = ReportDBUtil.deleteStudent(studentId);

        // Set the response content type
        response.setContentType("text/html");

        // Get the PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // Write the response
        out.println("<html><body>");
        if (deleted) {
        	out.println("<script type=\"text/javascript\">"); 
        	out.println("alert(' "+studentId+" ID Records are Sucessfuly Deleted');"); 
        	out.println("location='searchstudent.jsp';"); 
        	out.println("</script>");
        } else {
            out.println("<h1>Failed to Delete Student</h1>");
        }
        out.println("</body></html>");
    
	}

}
