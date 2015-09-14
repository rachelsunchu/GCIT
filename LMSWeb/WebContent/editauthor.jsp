<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>    
<%@ page import=" com.gcit.lms.domain.Author"%>
<%@ page import=" com.gcit.lms.dao.AuthorDAO"%>
<%int authorId = Integer.parseInt(request.getParameter("authorId"));

Author author1 = new Author();
AdministratorService admin = new AdministratorService();
author1 = admin.viewAuthorById(authorId);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editAuthors" method="post">
<input type="hidden" value="<%=authorId%>" name="authorId">
Enter the New Author Name:<input type="text" value="<%=author1.getAuthorName()%>" name="authorName">
<input type="submit"  value="Submit">
</form>
</body>
</html>