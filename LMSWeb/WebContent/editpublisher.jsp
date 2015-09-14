<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Publisher"%> 
<%int publisherId = Integer.parseInt(request.getParameter("publisherId"));

Publisher publisher1 = new Publisher();
AdministratorService admin = new AdministratorService();
publisher1 = admin.viewPublisherById(publisherId); %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="editPublisher" method="post">
<input type="hidden" value="<%=publisherId%>" name="publisherId">
Enter the New Publisher Name:<input type="text" value="<%=publisher1.getPublisherName()%>" name="publisherName">
Enter the New Publisher Address:<input type="text" value="<%=publisher1.getPublisherAddress()%>" name="publisherAddress">
Enter the New Publisher Phone:<input type="text" value="<%=publisher1.getPublisherPhone()%>" name="publisherPhone">
<input type="submit"  value="Submit">
</form>
</body>
</html>