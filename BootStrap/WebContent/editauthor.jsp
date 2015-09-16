<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>    
<%@ page import=" com.gcit.lms.domain.Author"%>
<%@ page import=" com.gcit.lms.dao.AuthorDAO"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%int authorId = Integer.parseInt(request.getParameter("authorId"));
Author author = new Author();
author.setAuthorId(authorId);
Author author1 = new Author();
AdministratorService admin = new AdministratorService();
author1 = admin.viewAuthorById(author);

%>

<div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Author</h4>
        </div>
        <div class="modal-body">
          
<form action="editAuthors" method="post">
<input type="hidden" value="<%=authorId%>" name="authorId">
Enter the New Author Name:<input type="text" value="<%=author1.getAuthorName()%>" style="width: 300px;" class="form-control" name="authorName">
<input type="submit" class="btn btn-xs btn-success" value="Submit">
</form>
</div>