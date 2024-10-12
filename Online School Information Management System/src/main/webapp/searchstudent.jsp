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
    <style>
    	form {
    width: 500px;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
    margin: auto;
    overflow: auto;
  }
  
  input[type="text"],
  input[type="number"],
  textarea {
    width: calc(100% - 22px);
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    font-size: 16px;
  }
  
  textarea {
    height: 100px;
  }
  
  input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    text-align: center;
    float: right;
  }
  h1 {
  	text-align: center;
	}
  
  input[type="submit"]:hover {
    background-color: #45a049;
  }
  input.button {
  transition-duration: 0.4s;
}

	input.button:hover {
  background-color: red;
  color: white;
}
  
    </style>
    <link rel="stylesheet" type="text/css" href="HeaderFooter.css">
</head>
<body>
	<div class="getleft">    
        <div class="image">
            <img src="images/logo.jpg" alt="ParkX logo" class="logo">
        </div>
    </div>
    <div class="container colornav topBotomBordersIn">    
        <a href="Course.jsp">Manage Course</a>
        <a href="Reportin.jsp">Generate Reports</a>
        <a href="searchstudent.jsp">Search Student</a>
    </div><br><br>
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
                <input class="button" type="submit" value="Delete">
            </form>
        </c:when>
        
    </c:choose>
</body>
</html>