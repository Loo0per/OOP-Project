<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Search Student</title>
    <script>
        function confirmDelete() {
            return confirm("Are you sure you want to delete this Student Details?");
        }
    </script>
</head>
<body>
    <h1>Search Student</h1>
    <form action="SearchStudentServlet" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required>
        <input type="submit" value="Search">
    </form>
  
    <c:choose>
	            <c:when test="${student != null}">
            <h1>Student Details</h1>
            <form method="post" action="UpdateStudentServlet">
                <input type="hidden" name="studentId" value="${student.id}">
                <label>Name:</label>
                <input type="text" name="name" value="${student.name}"><br>
                <label>Attendance:</label>
                <input type="number" name="attendance" min="0" max="100" value="${student.attendance}"><br>
                <label>Marks:</label>
                <input type="number" name="marks" min="0" max="100" value="${student.marks}"><br>
                <label>Grade:</label>
                <input type="text" name="grade" value="${student.grade}" readonly><br>
                <input type="submit" value="Update">
            </form>
            <form method="post" action="DeleteStudentServlet" onsubmit="return confirmDelete()">
                <input type="hidden" name="studentId" value="${student.id}">
                <input type="submit" value="Delete">
            </form>
        </c:when>
        
    </c:choose>
</body>
</html>