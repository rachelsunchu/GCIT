<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%String branchName = request.getParameter("branchName");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
You have selected: <%=branchName %>
<p>
<a href="updatedetails.jsp?branchName=<%=branchName%>">Update details of the library</a><br/>
<a href="addcopies.jsp?branchName=<%=branchName%>">Add copies of book to the branch</a><br/>
<a href="branch.jsp">Quit to previous</a><br/>
</p>
</body>
</html>