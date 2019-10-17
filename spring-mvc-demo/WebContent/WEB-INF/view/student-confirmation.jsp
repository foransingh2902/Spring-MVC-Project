<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- need this one to use the jstl tag library to loop over array -->    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student confirmation</title>
</head>
<body>
the student is confirmed :${student.firstName} ${student.lastName}
 <!--  calls student.getFirstName -->
 <br><br>
 ${student.country}
 <br><br>
 ${student.favoriteLanguage}
 <br><br>
 Operating Systems:
 <ul>
 <c:forEach var="temp" items="${student.operatingSystems }">
 <li>${temp}</li>
 </c:forEach>
 </ul>
</body>
</html>