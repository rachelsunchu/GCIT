<%@include file ="include.html" %>
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
<br><br>
<br><br>
<br>
<br><br>
<br><br><br><br>
<form action="checkOut" method="post">
		Select book: 
		<select name="title">
		 
			<%for (Book k : books) {%>
			
			<option value="<%=k.getBookId()%>"><%=k.getTitle()%></option>
			<%}%>
		</select>
		<button type="submit" name="submit" class="btn btn-sm btn-success" value="Submit">Next</button>
		 <input type ="hidden" value="<%=cardNo %>" name="cardNo">
		  <input type ="hidden" value="<%=branchId%>" name="branchId">
	</form>

</body>
</html>