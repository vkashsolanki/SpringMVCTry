<%@page import="org.hibernate.SessionFactory"%>
<%@page import="com.mvc.hiber.FactroyProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>
<h1>It is created by help of Spring mvc</h1>
<form action="register" method="post">
<input type="text" name="name" required="required" placeholder="Enter Name">
<br>
<input type="password" name="password" required="required" placeholder="Enter password">
<br>

<input type="email" name="email" required="required" placeholder="Enter Email">
<br>
<input type="tel" name="mobile" required="required" placeholder="Enter Mobile">
<br>

<input type="submit" value="Register">

</form>



</body>
</html>