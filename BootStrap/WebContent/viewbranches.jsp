<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%AdministratorService admin = new AdministratorService();
	List<Branch> branches = new ArrayList<Branch>();
	if(request.getAttribute("branches")!=null){
		branches = (List<Branch>)request.getAttribute("branches");
	}else{
		branches = admin.viewBranches();
	}
%>
<br><br><br><br>
<form action="searchBranches" method ="post">
 <div class="col-lg-4">
<input type="text" class="form-control" name="search" placeholder="Enter the Branch Name" ></div>
<input type="submit" value="Submit"></form>
<h2> View Existing Branches</h2>
<table class="table table-hover">
	<tr>
	<th>Branch Id</th>
	<th>Name</th>
	<th>Address</th>
	
	<th>Edit Branch</th>
	<th>Delete Branch</th>
	</tr>
	<%for(Branch br: branches){ %>
		<tr>
			<td align="center"><%=br.getBranchId() %></td>
			<td align="center"><%=br.getBranchName() %></td>
			<td align="center"><%=br.getBranchAddress() %></td>
			
			<td align="center"><button type="button" class="btn btn-xs btn-info" data-toggle="modal" data-target="#exampleModal"href='editbranch.jsp?branchId=<%=br.getBranchId()%>'">EDIT</button></td>
			<td align="center"><button type="button" class="btn btn-xs btn-danger" onclick="javascript:location.href='deleteBranch?branchId=<%=br.getBranchId()%>'">DELETE</button></td>
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