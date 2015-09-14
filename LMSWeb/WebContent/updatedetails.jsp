<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.gcit.lms.web.AdminServlet" %>
<%@page import="com.gcit.lms.domain.Branch" %>
<%@page import="com.gcit.lms.service.AdministratorService" %>
<%int branchId = Integer.parseInt(request.getParameter("branchName"));%>
<% 
   AdministratorService admin = new AdministratorService();
   Branch branch1 = new Branch();
   branch1 = admin.viewBranchByBranchId(branchId);
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
You have chosen to update the Branch with Branch Id:<%=branchId %> and Branch Name: <%=branch1.getBranchName() %>
Click 'quit' at any prompt to cancel operation.</br>
<input type="button" value="Quit" onclick="selectAction"></br>
Please enter new branch name : 
<form action="updateDetails" method="post">
<input type="hidden" value="<%=branchId%>" name="branchId">
<input type="text" name="branchName" value="<%=branch1.getBranchName()%>">


Please enter new branch address:

<input type="text" name="branchAddress" value="<%=branch1.getBranchAddress() %>" %>
<input type="submit" value="Submit">
</form>
</body>
</html>