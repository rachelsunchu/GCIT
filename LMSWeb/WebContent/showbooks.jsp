<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import=" com.gcit.lms.service.BorrowerService"%>
<%@ page import=" com.gcit.lms.domain.BookLoans"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%BorrowerService bor = new BorrowerService();
int cardNo = Integer.parseInt((String) session.getAttribute("CardNo"));
 List<BookLoans> books = new ArrayList<BookLoans>();
 books = bor.showBooks(cardNo);
 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GCIT LMS</title>
</head>
<body>

<table>
	<tr>
	
	<th>Book Title</th>
	<th>Branch Id</th>
	<th>Due Date</th>
	<th>Return Book</th>
	</tr>
	
	<%for(BookLoans b: books){ %>
	
		<tr>
			<td align="center"><%=b.getBook().getTitle() %></td>
			<td align="center"><%=b.getBranch().getBranchName() %></td>
			<td align="center"><%=b.getDueDate() %></td>
			<td align="center"><button type="button" onclick="javascript:location.href='returnBook?cardNo=<%=b.getBorrower().getCardNo()%>'">RETURN</button></td>
		    <td align="center"><input type="hidden" value=<%=b.getBook().getBookId()%> name="bookId"></td>
		    <td align="center"><input type="hidden" value="<%=b.getBranch().getBranchId()%>" name="branchId"></td>
		</tr>
		
	<%} %>
	
</table>

</body>
</html>