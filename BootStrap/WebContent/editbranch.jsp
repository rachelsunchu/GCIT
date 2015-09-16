<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Branch"%> 
<%int branchId = Integer.parseInt(request.getParameter("branchId"));

Branch branch1 = new Branch();
AdministratorService admin = new AdministratorService();
branch1 = admin.viewBranchByBranchId(branchId); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="editBranch" method="post">
<input type="hidden" value="<%=branchId%>" name="branchId">
Enter the New Branch Name:<input type="text" value="<%=branch1.getBranchName()%>" name="branchName">
Enter the New Branch Address:<input type="text" value="<%=branch1.getBranchAddress()%>" name="branchAddress">

<input type="submit"  value="Submit">
</form>
</body>
</html>