<%@include file ="include.html" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.BookLoans"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
    List<BookLoans> book = new ArrayList<BookLoans>();
   	book = admin.viewLoans();%>
<br><br>
<br><br>
<br>
<br><br>
<br><br><br><br>
<body>

<table>
	<tr>
	<th>Book ID</th>
	<th>Branch ID</th>
	<th>Card No</th>
	<th>Date Out</th>
	<th>Due Date</th>
	</tr>
	
	<%for(BookLoans k: book){ %>
	
		<tr>
			<td align="center"><%=k.getBook().getBookId()%></td>
			<td align="center"><%=k.getBranch().getBranchId()%></td>
			<td align="center"><%=k.getBorrower().getCardNo()%></td>
			<td align="center"><%=k.getDateOut()%></td>
			<td align="center"><%=k.getDueDate()%></td>
			<td align="center"><button type="button" class="btn btn-sm btn-info" onclick="javascript:location.href='dueDate?bookId=<%=k.getBook().getBookId()%>&branchId=<%=k.getBranch().getBranchId()%>&cardNo=<%=k.getBorrower().getCardNo()%>'">Over Ride</button></td>
		</tr>
	<%} %>
	
</table>

</body>
</html>