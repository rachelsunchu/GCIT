<%@include file ="include.html" %>

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
<br><br>
<br><br>
<br>
<br><br>
<br><br><br><br>
<form action="addBooks" method="post">
Select Author:
<select name="authorId">
<%for(Author a: authors){ %>
	<option value="<%=a.getAuthorId() %>" ><%=a.getAuthorName() %></option>	
<%} %>
</select><br>
Enter the new Book:<center><input type="text" style="width: 300px;" class="form-control"  name="title"></center>
Select Publisher Id:
<select name="publisherId">
<%for(Publisher p: publishers){ %>
	<option  value="<%=p.getPublisherId() %>" ><%=p.getPublisherId() %></option>	
<%} %>
</select>
<button type="button" class="btn btn-sm btn-success">Submit</button>
</form>
