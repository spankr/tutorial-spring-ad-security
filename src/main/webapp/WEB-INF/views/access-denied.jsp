<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access Denied</title>
</head>
<body>
	<h1>Access Denied</h1>
	<span id="userDetail">
	  <security:authorize access="isAuthenticated()">
	    <%
	      String user = (String)request.getRemoteUser();
	        if (user != null) {
	    %>
	    Sorry, <%=user%>.
	    <%
	      }
	    %>
	  </security:authorize>
	 </span>
	
	<p>Your access to the requested page has been denied.</p>
	
	<p><a href='<c:url value="/index"/>'>Home</a></p>
</body>
</html>