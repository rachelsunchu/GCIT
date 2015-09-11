<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.assignment4.database.JDBC"%>    
<%@ page import=" com.gcit.assignment4.domain.Author"%>
<%int authorId = Integer.parseInt(request.getParameter("authorId"));
JDBC jdbc = new JDBC();
Author author1 = new Author();
Author author = new Author();
author1.setAuthorId(authorId);
author = jdbc.editAuthors(author1);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editAuthors" method="post">
<input type="hidden" value="<%=author.getAuthorId()%>" name="authorId">
Enter the New Author Name:<input type="text" value="<%=author.getAuthorName()%>" name="authorName">
<input type="submit"  value="Submit">
</form>
</body>
</html>