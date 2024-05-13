<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Search Student</title>
</head>
<body>
    <h1>Search Student</h1>
    <form action="SearchStudentServlet" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required>
        <input type="submit" value="Search">
    </form>
</body>
</html>