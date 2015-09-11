<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" com.gcit.assignment4.database.JDBC"%>
<%@ page import=" com.gcit.assignment4.domain.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<% JDBC jdbc = new JDBC();
   	List<Book> books = new ArrayList<Book>();
   	books = jdbc.getBooks();
   	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="addCopies" method="post">
		Select book: 
		<select name="title">
			<%for (Book k : books) {%>
			<option value="<%=k.getTitle()%>"><%=k.getTitle()%></option>
			<%}%>
		</select>
		<button type="submit" name="submit" value="Submit">Next</button>

	</form>

</body>
</html>