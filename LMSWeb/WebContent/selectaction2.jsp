<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String cardNo = request.getParameter("cardNo");
System.out.println(cardNo);
session.setAttribute("CardNo", cardNo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<p>
<a href="branch2.jsp">Check out a Book</a><br/>
<a href="showbooks.jsp">Return a Book</a><br/>
<a href="borrower.jsp">Quit to previous</a><br/>
</p>
</body>
</html>