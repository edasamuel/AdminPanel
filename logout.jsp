<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
session = request.getSession(false);
session.setAttribute("admin", null);
session.invalidate();
response.sendRedirect("../login.jsp");
%>