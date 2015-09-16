<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Book> books = new ArrayList<Book>();
	if(request.getAttribute("books")!=null){
		books = (List<Book>)request.getAttribute("books");
	}else{
		books = admin.viewBooks();
	}
%>
<br><br><br><br>
<form action="searchBooks" method ="post">
 <div class="col-lg-4">
<input type="text" class="form-control" name="search" placeholder="Enter the Book Name" ></div>
<input type="submit" value="Submit"></form>
<h2> View Existing Books</h2>

<table class="table table-hover">
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
			<td align="center"><button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal" href='editbook.jsp?bookId=<%=k.getBookId()%>'">EDIT</button></td>
			<td align="center"><button type="button" class="btn btn-xs btn-danger" onclick="javascript:location.href='deleteBook?bookId=<%=k.getBookId()%>'">DELETE</button></td>
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