<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Home page</title>
  </head>
  <%
    LocalDate now = LocalDate.now();
  %>
  <body>
    <h3>Hi, Sample servlet application</h3>
    <p>Date - <%=now.toString()%></p>
  </body>
</html>