<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" com.gcit.lms.service.AdministratorService"%>
<%@ page import=" com.gcit.lms.domain.Publisher"%> 
<%int publisherId = Integer.parseInt(request.getParameter("publisherId"));

Publisher publisher1 = new Publisher();
AdministratorService admin = new AdministratorService();
publisher1 = admin.viewPublisherById(publisherId); %> 
<div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Edit Author</h4>
        </div>
        <div class="modal-body">
<form action="editPublisher" method="post">
<input type="hidden" value="<%=publisherId%>" name="publisherId">
Enter the New Publisher Name:<input type="text" value="<%=publisher1.getPublisherName()%>" style="width: 300px;" class="form-control" name="publisherName">
Enter the New Publisher Address:<input type="text" value="<%=publisher1.getPublisherAddress()%>" style="width: 300px;" class="form-control" name="publisherAddress">
Enter the New Publisher Phone:<input type="text" value="<%=publisher1.getPublisherPhone()%>" style="width: 300px;" class="form-control" name="publisherPhone">
<input type="submit" class="btn btn-xs btn-success" value="Submit">
</form>
</body>
</html>