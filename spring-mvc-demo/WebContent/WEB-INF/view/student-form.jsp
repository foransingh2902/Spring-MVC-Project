<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- remember to add the taglib to use the spring tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
<!-- modelAttribute="student" must match with the addAtttribute() in the controller code -->
First Name :<form:input path="firstName"/>
<!-- firstName is the property of Student class. Path to property for data binding -->
<br><br>
Last Name :<form:input path="lastName"/>
<br><br>
Country : 
<form:select path="country">
<!-- on submit, spring will call student.setCountry -->
<!--  
<form:option value="Brazil" label="Brazil"></form:option>
<form:option value="France" label="France"></form:option>
<form:option value="Germany" label="Germany"></form:option>
<form:option value="India" label="India"></form:option>
-->
<!-- now alternate -->
<!-- items refer to the collection of data -->
<!-- Spring will call student.getCountryOptions() to populate the form -->
<form:options items="${student.countryOptions}"/>
</form:select>
<br><br>

Favorite Language :
java <form:radiobutton path="favoriteLanguage" value="Java"/>
C# <form:radiobutton path="favoriteLanguage" value="C#"/>
PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
<!-- on  submit, Spring will call student.setFavoriteLanguage(...) -->
<br><br>
Operating Systems:
Linux<form:checkbox path="operatingSystems" value="Linux"/>
Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>
Windows OS<form:checkbox path="operatingSystems" value="Windows OS"/>
<!-- on submit, Spring will call student.setOperatingSystems(...) -->


<br><br>
<input type="submit" value="Submit"/>
<!--  when form is loaded Spring MVC will call:
student.getFirstName()
student.getLastName() i.e. when loaded in the view.jsp page
for the client response
 -->
 
 <!-- When form is submitted Spring MVC will call:
 student.setFirstName(...)
 ...
 student.setLastName(...)
  -->
</form:form>
</body>
</html>