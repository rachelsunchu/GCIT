<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Borrower"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Borrower> borrowers = new ArrayList<Borrower>();
	if(request.getAttribute("borrowers")!=null){
		borrowers = (List<Borrower>)request.getAttribute("borrowers");
	}else{
		borrowers = admin.viewBorrowers();
	}
%>
<br><br><br><br>
<form action="searchBorrowers" method ="post">
 <div class="col-lg-4">
<input type="text" class="form-control" name="search" placeholder="Enter the Borrower Name" ></div>
<input type="submit" value="Submit"></form>
<h2> View Existing Borrowers</h2>
<table class="table table-hover">
	<tr>
	<th>Card No</th>
	<th>Name</th>
	<th>Address</th>
	<th>Phone</th>
	<th>Edit Borrower</th>
	<th>Delete Borrower</th>
	</tr>
	<%for(Borrower l: borrowers){ %>
		<tr>
			<td align="center"><%=l.getCardNo() %></td>
			<td align="center"><%=l.getName() %></td>
			<td align="center"><%=l.getAddress() %></td>
			<td align="center"><%=l.getPhone() %></td>
			<td align="center"><button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal" href='editborrower.jsp?cardNo=<%=l.getCardNo()%>'">EDIT</button></td>
			<td align="center"><button type="button" class="btn btn-xs btn-danger" onclick="javascript:location.href='deleteBorrower?cardNo=<%=l.getCardNo()%>'">DELETE</button></td>
			</tr>
	<%} %>
	
</table>
<div id="exampleModal" class="modal fade" tabindex="-1" role="dialog"
   aria-labelledby="myLargeModalLabel">
   <div class="modal-dialog modal-lg">
      <div class="modal-content">
      
      </div>
   </div>
</div>
