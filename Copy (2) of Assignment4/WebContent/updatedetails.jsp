<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.gcit.assignment4.web.AdminServlet" %>
<%@page import="com.gcit.assignment4.domain.Branch" %>
<%int branchId = Integer.parseInt(request.getParameter("branchName")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
You have chosen to update the Branch with Branch Id:<%=branchId%> and Branch Name :
Click 'quit' at any prompt to cancel operation.</br>
<input type="button" value="Quit" onclick="selectAction"></br>
Please enter new branch name or enter N/A for no change: 
<form action="updateBranchName" method="post">
<input type="hidden" value="<%=branchId %>" name="branchId">
<input type="text" name="branchName">
<input type="submit" value="Submit">
</form>
Please enter new branch address or enter N/A for no change:
<form action="updateBranchAddress" method="post">
<input type="text" name="branchAddress">
<input type="submit" value="Submit">
</form>
</body>
</html>