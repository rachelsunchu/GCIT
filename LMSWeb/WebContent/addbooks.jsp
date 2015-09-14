<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.gcit.lms.domain.Author"%>
 <%@ page import="com.gcit.lms.domain.Publisher"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Author> authors = new ArrayList<Author>();
	authors = admin.viewAuthors();
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
<form action="addBooks" method="post">
Select Author:
<select name="authorId">
<%for(Author a: authors){ %>
	<option value="<%=a.getAuthorId() %>" ><%=a.getAuthorName() %></option>	
<%} %>
</select>
Enter the new Book:<input type="text" name="title">
Select Publisher Id:
<select name="publisherId">
<%for(Publisher p: publishers){ %>
	<option value="<%=p.getPublisherId() %>" ><%=p.getPublisherId() %></option>	
<%} %>
</select>
<input type="submit" value="Submit">
</form>
</body>
</html>