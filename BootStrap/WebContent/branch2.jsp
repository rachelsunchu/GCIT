<%@include file ="include.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.BorrowerService"%>
<%@ page import=" com.gcit.lms.domain.Branch"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%
	BorrowerService bor = new BorrowerService();
	List<Branch> branches = new ArrayList<Branch>();
	branches = bor.getAllBranches();
%>
<br><br>
<br><br>
<br>
<br><br>
<br><br><br><br>
	<form action="selectedBranch2" method="post">
		Select branch: 
		<select name="branchName">
			<%for (Branch b : branches) {%>
			<option value="<%=b.getBranchId()%>"><%=b.getBranchName()%></option>
			<%}%>
		</select>
		<button type="submit" name="submit" class="btn btn-sm btn-success" value="Submit">Next</button>
	</form>
