<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.assignment4.database.JDBC"%>
<%@ page import=" com.gcit.assignment4.domain.Book"%>
<%@ page import=" com.gcit.assignment4.domain.Author"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%JDBC jdbc = new JDBC();

%>
<%int bookId = Integer.parseInt(request.getParameter("bookId"));
Book book1 = new Book();
Book book = new Book();
book1.setBookId(bookId);
book = jdbc.editBooks(book1);

%>
<%


%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="editBooks" method="post">
<input type="hidden" value="<%=book.getBookId()%>" name="bookId">
Enter the New Title:<input type="text" value="<%=book.getTitle()%>" name="title">

<input type="submit"  value="Submit">
</form>
</body>
</html>