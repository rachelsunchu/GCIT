<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Book> books = new ArrayList<Book>();
	books = admin.viewBooks();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<h2> View Existing Books</h2>

<table>
	<tr>
	<th>Book ID</th>
	<th>Title</th>
	<th>Edit Book</th>
	<th>Delete Book</th>
	</tr>
	<%for(Book k: books){ %>
		<tr>
			<td align="center"><%=k.getBookId() %></td>
			<td align="center"><%=k.getTitle() %></td>
			<td align="center"><button type="button" onclick="javascript:location.href='editbook.jsp?bookId=<%=k.getBookId()%>'">EDIT</button></td>
			<td align="center"><button type="button" onclick="javascript:location.href='deleteBook?bookId=<%=k.getBookId()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>

</body>
</html>