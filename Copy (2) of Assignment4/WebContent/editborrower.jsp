<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import=" com.gcit.assignment4.database.JDBC"%>
<%@ page import=" com.gcit.assignment4.domain.Borrower"%>
<%JDBC jdbc = new JDBC();
int cardNo = Integer.parseInt(request.getParameter("cardNo"));
Borrower borrower1 = new Borrower();
Borrower borrower = new Borrower();
borrower1.setCardNo(cardNo);
borrower = jdbc.editBorrowers(borrower1); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="editBorrowers" method="post">
<input type="hidden" value="<%=borrower.getCardNo()%>" name="cardNo">
Enter the New Name:<input type="text" value="<%=borrower.getName()%>" name="name">
Enter the New Address:<input type="text" value="<%=borrower.getAddress()%>" name="address">
Enter the New Phone:<input type="text" value="<%=borrower.getPhone()%>" name="phone">
<input type="submit"  value="Submit">
</form>
</body>
</html>