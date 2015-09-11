<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.assignment4.database.JDBC"%>
<%@ page import=" com.gcit.assignment4.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
	JDBC jdbc = new JDBC();
	List<Branch> branches = new ArrayList<Branch>();
	branches = jdbc.selectBranch();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
	<form action="selectedBranch" method="post">
		Select branch: 
		<select name="branchName">
			<%for (Branch b : branches) {%>
			<option value="<%=b.getBranchId()%>"><%=b.getBranchName()%></option>
			<%}%>
		</select>
		<button type="submit" name="submit" value="Submit">Next</button>
	</form>
</body>
</html>