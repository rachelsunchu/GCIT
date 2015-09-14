<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Publisher"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Publisher> publishers = new ArrayList<Publisher>();
	publishers = admin.viewPublishers();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<h2> View Existing Publishers</h2>
<table>
	<tr>
	<th>Publisher ID</th>
	<th>Publisher Name</th>
	<th>Publisher Address</th>
	<th>Publisher Phone</th>
	<th>Update Publisher</th>
	<th>Delete Publisher</th>
	</tr>
	<%for(Publisher p: publishers){ %>
		<tr>
			<td align="center"><%=p.getPublisherId() %></td>
			<td align="center"><%=p.getPublisherName() %></td>
			<td align="center"><%=p.getPublisherAddress() %></td>
			<td align="center"><%=p.getPublisherPhone() %></td>
			<td align="center"><button type="button" onclick="javascript:location.href='editpublisher.jsp?publisherId=<%=p.getPublisherId()%>'">EDIT</button></td>
			<td align="center"><button type="button" onclick="javascript:location.href='deletePublisher?publisherId=<%=p.getPublisherId()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>

</body>
</html>