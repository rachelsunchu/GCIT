<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.BorrowerService"%>
<%@ page import=" com.gcit.lms.domain.Book"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%BorrowerService bor = new BorrowerService();
     int branchId = Integer.parseInt(request.getParameter("branchName"));
     Branch branch = new Branch();
     branch.setBranchId(branchId);
     List<Book> books = new ArrayList<Book>();
     books = bor.getAllBooksByBranchId(branch);
     String cardNo = (String) session.getAttribute("CardNo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>
<form action="checkOut" method="post">
		Select book: 
		<select name="title">
		 
			<%for (Book k : books) {%>
			
			<option value="<%=k.getBookId()%>"><%=k.getTitle()%></option>
			<%}%>
		</select>
		<button type="submit" name="submit" value="Submit">Next</button>
		 <input type ="hidden" value="<%=cardNo %>" name="cardNo">
		  <input type ="hidden" value="<%=branchId%>" name="branchId">
	</form>

</body>
</html>