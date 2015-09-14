<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Borrower"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Borrower> borrowers = new ArrayList<Borrower>();
	borrowers = admin.viewBorrowers();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<h2> View Existing Borrowers</h2>
<table>
	<tr>
	<th>Card No</th>
	<th>Name</th>
	<th>Address</th>
	<th>Phone</th>
	<th>Edit Borrower</th>
	<th>Delete Borrower</th>
	</tr>
	<%for(Borrower l: borrowers){ %>
		<tr>
			<td align="center"><%=l.getCardNo() %></td>
			<td align="center"><%=l.getName() %></td>
			<td align="center"><%=l.getAddress() %></td>
			<td align="center"><%=l.getPhone() %></td>
			<td align="center"><button type="button" onclick="javascript:location.href='editborrower.jsp?cardNo=<%=l.getCardNo()%>'">EDIT</button></td>
			<td align="center"><button type="button" onclick="javascript:location.href='deleteBorrower?cardNo=<%=l.getCardNo()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>

</body>
</html>