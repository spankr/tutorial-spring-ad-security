<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Page</title>
	    <!-- using c:url will properly reference urls that are local to your webapp -->
	    <c:url var="samplecss" value="/resources/css/sample.css"/>
	    <link rel="stylesheet" type="text/css" media="screen" href="${samplecss}"/>
	</head>
	<body>
		<div id="contentWrapper" align="center">
			<h2>Login Page</h2><br>
            <%
                String error = request.getParameter("error");
                if (error != null) {
            %>
            <p style="color: red"><%=error%></p>
            <%
                }
            %>
			<c:url var="loginAction" value="/login" />
			<form action="${loginAction}" method="POST">
				<table width="260px">
					<col width="100px">
					<col width="160px">
					<tr>
						<td>Username:</td>
						<td><input type="text" id="username" name="username" value="" class="input"/></td>
          </tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" id="password" name="password" value="" class="input" autocomplete="off"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" value="Login" /></td>
					</tr>
				</table>
				<security:csrfInput/>
			</form>
		</div>
	</body>
</html>
