<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Borrower"%> 
<%int cardNo = Integer.parseInt(request.getParameter("cardNo"));

Borrower borrower1 = new Borrower();
AdministratorService admin = new AdministratorService();
borrower1 = admin.viewBorrowerByCardNo(cardNo); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="editBorrowers" method="post">
<input type="hidden" value="<%=cardNo%>" name="cardNo">
Enter the New Borrower Name:<input type="text" value="<%=borrower1.getName()%>" name="name">
Enter the New Borrower Address:<input type="text" value="<%=borrower1.getAddress()%>" name="address">
Enter the New Borrower Phone:<input type="text" value="<%=borrower1.getPhone()%>" name="phone">
<input type="submit"  value="Submit">
</form>
</body>
</html>