<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Book"%>
<%@ page import=" com.gcit.lms.domain.Author"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();

%>
<%int bookId = Integer.parseInt(request.getParameter("bookId"));
     
     Book book = new Book();
     book = admin.viewBookByBookId(bookId);
%>
<%%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="editBooks" method="post">
<input type="hidden" value="<%=bookId%>" name="bookId">
Enter the New Title:<input type="text" style="width: 300px;" class="form-control" value="<%=book.getTitle()%>" name="title">

<input type="submit"  value="Submit">
</form>
</body>
</html>