<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Publisher"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Publisher> publishers = new ArrayList<Publisher>();
	if(request.getAttribute("publishers")!=null){
		publishers = (List<Publisher>)request.getAttribute("publishers");
	}else{
		publishers = admin.viewPublishers();
	}
%>
<br><br><br><br>
<form action="searchPublishers" method ="post">
 <div class="col-lg-4">
<input type="text" class="form-control" name="search" placeholder="Enter the Publisher Name" ></div>
<input type="submit" value="Submit"></form>
<h2> View Existing Publishers</h2>
<table class="table table-hover">
	<tr>
	<th>Publisher ID</th>
	<th>Publisher Name</th>
	<th>Publisher Address</th>
	<th>Publisher Phone</th>
	<th>Update Publisher</th>
	<th>Delete Publisher</th>
	</tr>
	<%for(Publisher p: publishers){ %>
		<tr>
			<td align="center"><%=p.getPublisherId() %></td>
			<td align="center"><%=p.getPublisherName() %></td>
			<td align="center"><%=p.getPublisherAddress() %></td>
			<td align="center"><%=p.getPublisherPhone() %></td>
			<td align="center"><button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal" href='editpublisher.jsp?publisherId=<%=p.getPublisherId()%>'">EDIT</button></td>
			<td align="center"><button type="button" class="btn btn-xs btn-danger" onclick="javascript:location.href='deletePublisher?publisherId=<%=p.getPublisherId()%>'">DELETE</button></td>
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
