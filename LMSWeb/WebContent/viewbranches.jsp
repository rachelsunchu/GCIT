<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Branch> branches = new ArrayList<Branch>();
	branches = admin.viewBranches();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<h2> View Existing Branches</h2>
<table>
	<tr>
	<th>Branch Id</th>
	<th>Name</th>
	<th>Address</th>
	
	<th>Edit Branch</th>
	<th>Delete Branch</th>
	</tr>
	<%for(Branch br: branches){ %>
		<tr>
			<td align="center"><%=br.getBranchId() %></td>
			<td align="center"><%=br.getBranchName() %></td>
			<td align="center"><%=br.getBranchAddress() %></td>
			
			<td align="center"><button type="button" onclick="javascript:location.href='editbranch.jsp?branchId=<%=br.getBranchId()%>'">EDIT</button></td>
			<td align="center"><button type="button" onclick="javascript:location.href='deleteBranch?branchId=<%=br.getBranchId()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>

</body>
</html>