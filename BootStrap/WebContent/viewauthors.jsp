<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.gcit.lms.domain.Author"%>
<%@ page import="com.gcit.lms.service.AdministratorService"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Author> authors = new ArrayList<Author>();
	if(request.getAttribute("authors")!=null){
		authors = (List<Author>)request.getAttribute("authors");
	}else{
		authors = admin.viewAuthors();
	}
	
%>
<br><br><br><br>
<form action="searchAuthors" method ="post">
 <div class="col-lg-4">
<input type="text" class="form-control" name="search" placeholder="Enter the Author Name" ></div>
<input type="submit" value="Submit"></form>
<h2> View Existing Authors</h2>

<table class="table table-hover">
	<tr>
	
	<th><center>Author Name</center></th>
	<th>Edit Author</th>
	<th>Delete Author</th>
	</tr>
	<%for(Author a: authors){ %>
		<tr>
			
			<td align="center"><%=a.getAuthorName() %></td>
			<td align="center"><button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal" href='editauthor.jsp?authorId=<%=a.getAuthorId()%>'">EDIT</button></td>
			<td align="center"><button type="button" class="btn btn-xs btn-danger" onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getAuthorId()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>

<div id="exampleModal" class="modal fade" tabindex="-1" role="dialog"
   aria-labelledby="myLargeModalLabel">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
      </div>
   </div>
</div>

