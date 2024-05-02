<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ReportInsert" method="post">
		Student ID <input type="text" name="ID"><br>
		Student Name <input type="text" name="name"><br>
		Attendance <input type="text" name="att" min="0" max="100"><br>
		Marks <input type="text" name="marks" min="0" max="100"><br>
		
		<input type="submit" name="submit" value="Generate Grade">
	</form>
</body>
</html>