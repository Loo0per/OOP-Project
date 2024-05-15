<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	  
	  input[type="submit"]:hover {
	    background-color: #45a049;
	  }
	  h1 {
  		text-align: center;
		}
	  </style>
 <link rel="stylesheet" type="text/css" href="HeaderFooter.css">
<title>Insert title here</title>
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
	<form action="ReportInsert" method="post">
		Student ID <input type="text" name="ID"><br>
		Student Name <input type="text" name="name"><br>
		Attendance <input type="text" name="att" min="0" max="100"><br>
		Marks <input type="text" name="marks" min="0" max="100"><br>
		
		<input type="submit" name="submit" value="Generate Grade">
	</form>
</body>
</html>