<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String cardNo = request.getParameter("cardNo");
System.out.println(cardNo);
session.setAttribute("CardNo", cardNo);
%>
<br><br>
<br><br>
<br>
<br><br>
<br><br><br><br>
<p>
<a href="branch2.jsp">Check out a Book</a><br/>
<a href="showbooks.jsp">Return a Book</a><br/>
<a href="borrower.jsp">Quit to previous</a><br/>
</p>
</body>
</html>