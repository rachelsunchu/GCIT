<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.gcit.assignment4.domain.Author"%>
<%@ page import="com.gcit.assignment4.database.JDBC"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%JDBC jdbc = new JDBC();
	List<Author> authors = new ArrayList<Author>();
	authors = jdbc.getAuthors();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="addBooks" method="post">
Select Author:
<select name="authorId">
<%for(Author a: authors){ %>
	<option value="<%=a.getAuthorId() %>" ><%=a.getAuthorName() %></option>	
<%} %>
</select>
Enter the new Book:<input type="text" name="title">
<input type="submit" value="Submit">
</form>
</body>
</html>