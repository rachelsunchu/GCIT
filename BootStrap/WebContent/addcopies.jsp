<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" com.gcit.lms.service.LibrarianService"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import=" com.gcit.lms.domain.Book"%>
<%@ page import=" com.gcit.lms.domain.BookCopies"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%int branchId = Integer.parseInt(request.getParameter("branchName"));
    
    LibrarianService lib = new LibrarianService();
    List<BookCopies> book = new ArrayList<BookCopies>();
   	book = lib.viewBookCopiesByBranchId(branchId);
   	
   	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>

	<table>
	<tr>
	<th>Book ID</th>
	<th>Title</th>
	<th>No of Copies</th>
	<th>Delete Book</th>
	</tr>
	<%for(BookCopies k: book){ %>
	
		<tr>
			<td align="center"><%=k.getBooks().getBookId()%></td>
			<td align="center"><%=k.getBooks().getTitle() %></td>
			<td align="center"><%=k.getNoOfCopies() %></td>
			<td align="center"><input type="text" name="copies"></td>
			<td align="center"><button type="button" onclick="javascript:location.href='addCopies?bookId=<%=k.getBooks().getBookId()%>&branchId=<%=branchId%>'">ADD COPIES</button></td>
		</tr>
	<%} %>
	
</table>


<%=branchId%>
</body>
</html>