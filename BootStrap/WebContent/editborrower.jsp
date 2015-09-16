<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Borrower"%> 
<%int cardNo = Integer.parseInt(request.getParameter("cardNo"));

Borrower borrower1 = new Borrower();
AdministratorService admin = new AdministratorService();
borrower1 = admin.viewBorrowerByCardNo(cardNo); %> 
<div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Author</h4>
        </div>
        <div class="modal-body">
<form action="editBorrowers" method="post">
<input type="hidden" value="<%=cardNo%>" name="cardNo">
Enter the New Borrower Name:<input type="text" value="<%=borrower1.getName()%>" style="width: 300px;" class="form-control" name="name">
Enter the New Borrower Address:<input type="text" value="<%=borrower1.getAddress()%>" style="width: 300px;" class="form-control" name="address">
Enter the New Borrower Phone:<input type="text" value="<%=borrower1.getPhone()%>" style="width: 300px;" class="form-control" name="phone">
<input type="submit" class="btn btn-xs btn-success" value="Submit">
</form>
</body>
</html>