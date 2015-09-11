package com.gcit.assignment4.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gcit.assignment4.domain.Author;
import com.gcit.assignment4.domain.Book;
import com.gcit.assignment4.domain.Borrower;
import com.gcit.assignment4.domain.Branch;
import com.gcit.assignment4.domain.Publisher;
import com.gcit.assignment4.database.JDBC;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({"/addAuthor", "/updateBranchAddress", "/editBorrowers", "/editAuthors", "/editBooks", "/editBook",  "/addBooks", "/editAuthor","/checkOut", "/deleteBorrower", "/addCopies", "/addBorrowers", "/deletePublisher", "/selectedBranch2","/deleteBook", "/deleteAuthor", "/addPublisher", "/selectedBranch", "/updateBranchName", "/borrower"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
			request.getRequestURI().length());
	
	String forwardPath = "admin.html";
	switch (reqUrl) {
	
		

	case "/deleteAuthor":
		deleteAuthor(request);
		forwardPath="/author.jsp";
		break;
		
	
		
	
	
		
	case "/deleteBorrower":
		deleteBorrower(request);
		forwardPath="/borrower.jsp";
		break;
		
	case "/deleteBook":
		deleteBook(request);
		forwardPath="/book.jsp";
		break;
		
	case "/deletePublisher":
		deletePublisher(request);
		forwardPath="/publisher.jsp";
		break;
	case "/selectAction":
		
		forwardPath="/selectaction.jsp";
		break;
	}
	
	RequestDispatcher rd = request.getServletContext().getRequestDispatcher(forwardPath);
	rd.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reqUrl = request.getRequestURI().substring(request.getContextPath().length(),
				request.getRequestURI().length());
		
		
		String forwardPath = "admin.html";
		switch (reqUrl) {
		case"/selectedBranch":
			
			forwardPath = "/selectaction.jsp";
		    break;
		
		case "/editBooks":
			editBook(request);
			request.setAttribute("editBooksMessage", "Book Updated Sucessfully");
			forwardPath="/book.jsp";
			break;
			
		case "/editAuthors":
			editAuthor(request);
			request.setAttribute("editAuthorsMessage", "Author Updated Sucessfully");
			forwardPath="/author.jsp";
			break;
			
		case "/editBorrowers":
			editBorrower(request);
			request.setAttribute("editBorrowersMessage", "Borrower Updated Sucessfully");
			forwardPath="/borrowers.jsp";
			break;
		    
		case"/selectedBranch2":
			forwardPath = "/viewbooks1.jsp";
		    break;
		    
		case"/checkOut":
			updateBookLoans(request);
			forwardPath = "/selectaction2.jsp";
		    break;
		    
		case "/addAuthor":
			addAuthor(request);
			request.setAttribute("addAuthorMessage", "Author Added Sucessfully");
			forwardPath = "/author.jsp";
			break;
		
			
		case "/addBorrowers":
			addBorrowers(request);
			request.setAttribute("addBorrowerMessage", "Borrower Added Sucessfully");
			forwardPath = "/borrowers.jsp";
			break;
			
		case "/updateBranchName":
			updateBranchName(request);
			forwardPath = "/updatedetails.jsp";
			break;
			
		case "/updateBranchAddress":
			updateBranchAddress(request);
			forwardPath = "/selectaction.jsp";
			break;
			
		case "/addPublisher":
			addPublisher(request);
			request.setAttribute("addPublisherMessage", "Publisher Added Sucessfully");
			forwardPath = "/publisher.jsp";
			break;
			
		case "/borrower":
			access(request);
			forwardPath = access(request);
			break;
			
		case "/addCopies":
			countCopies(request);
			forwardPath = "/newcopies.jsp";
			break;
			
		case "/addBooks":
			addBooks(request);
			request.setAttribute("addBookMessage", "Book Added Sucessfully");
			forwardPath = "/book.jsp";
			break;
		
		default:
			break;
		}

		RequestDispatcher rd = request.getServletContext().getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}



  private void addAuthor(HttpServletRequest request) {
	String authorName = request.getParameter("authorName");
	Author author = new Author();
	author.setAuthorName(authorName);
	
	JDBC jdbc = new JDBC();
	jdbc.addAuthor(author);
  }
  
  private void editBooks(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book book = new Book();
		book.setBookId(bookId);
		
		JDBC jdbc = new JDBC();
		jdbc.editBook(book);
	  }
  
  private void editBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setTitle(title);
		
		JDBC jdbc = new JDBC();
		jdbc.editBook(book);
	  }
  
  private void editAuthor(HttpServletRequest request) {
	  int authorId = Integer.parseInt(request.getParameter("authorId"));
	  String authorName = request.getParameter("authorName");
		Author author = new Author();
		author.setAuthorName(authorName);
		author.setAuthorId(authorId);
			
		
		JDBC jdbc = new JDBC();
		jdbc.editAuthor(author);
	  }
  
  private void editAuthors(HttpServletRequest request) {
	  int authorId = Integer.parseInt(request.getParameter("authorId"));
	  	Author author = new Author();
		author.setAuthorId(authorId);
		
		JDBC jdbc = new JDBC();
		jdbc.editAuthors(author);
	  }
  
  private void editBorrower(HttpServletRequest request) {
	  int cardNo = Integer.parseInt(request.getParameter("cardNo"));
	  String name = request.getParameter("name");
	  String address = request.getParameter("address");
	  String phone = request.getParameter("phone");
		Borrower borrower = new Borrower();
		borrower.setName(name);
		borrower.setCardNo(cardNo);
		borrower.setAddress(address);
		borrower.setPhone(phone);
			
		
		JDBC jdbc = new JDBC();
		jdbc.editBorrower(borrower);
	  }
  
  private void editBorrowers(HttpServletRequest request) {
	  int cardNo = Integer.parseInt(request.getParameter("cardNo"));
	  Borrower borrower = new Borrower();
		borrower.setCardNo(cardNo);
		
		JDBC jdbc = new JDBC();
		jdbc.editBorrowers(borrower);
	  }
  
 
  
  private void addBooks(HttpServletRequest request) {
		int authorId = Integer.parseInt (request.getParameter("authorId"));
		String title = request.getParameter("title");
		Author author = new Author();
		author.setAuthorId(authorId);
		Book book = new Book();
		book.setTitle(title);
		
		
		JDBC jdbc = new JDBC();
		jdbc.addBooks(author,book);
	  }
  
  private void addPublisher(HttpServletRequest request) {
		
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");
		Publisher publisher = new Publisher();
		
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		
		JDBC jdbc = new JDBC();
		jdbc.addPublisher(publisher);
	  }
  
  private void addBorrowers(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Borrower borrower = new Borrower();
		
		borrower.setName(name);
		borrower.setAddress(address);
		borrower.setPhone(phone);
		
		JDBC jdbc = new JDBC();
		jdbc.addBorrowers(borrower);
	  }
  
  private void editPublishers(HttpServletRequest request) {
		
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");
		Publisher publisher = new Publisher();
		
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		
		JDBC jdbc = new JDBC();
		jdbc.addPublisher(publisher);
	  }
  
  private void deleteAuthor(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		
		Author author = new Author();
		
		author.setAuthorId(Integer.parseInt(authorId));
		
		JDBC jdbc = new JDBC();
		jdbc.deleteAuthor(author);
	  }
  
  private void countCopies(HttpServletRequest request) {
		String title = request.getParameter("title");
		
		Book book = new Book();
		
		book.setTitle(title);
		
		JDBC jdbc = new JDBC();
		jdbc.countCopies(book);
	  }
  
  private void deleteBorrower(HttpServletRequest request) {
		String cardNo = request.getParameter("cardNo");
		
		Borrower borrower = new Borrower();
		
		borrower.setCardNo(Integer.parseInt(cardNo));
		
		JDBC jdbc = new JDBC();
		jdbc.deleteBorrower(borrower);
	  }
  
  private void deleteBook(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		
		Book book = new Book();
		
		book.setBookId(Integer.parseInt(bookId));
		
		JDBC jdbc = new JDBC();
		jdbc.deleteBook(book);
	  }
  
  private void deletePublisher(HttpServletRequest request) {
		String publisherId = request.getParameter("publisherId");
		
		Publisher publisher = new Publisher();
		
		publisher.setPublisherId(Integer.parseInt(publisherId));
		
		JDBC jdbc = new JDBC();
		jdbc.deletePublisher(publisher);
	  }
  
  /*private void editAuthor(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		
		Author author = new Author();
		
		author.setAuthorId(Integer.parseInt(authorId));
		
		JDBC jdbc = new JDBC();
		jdbc.editAuthor(author);
	  }*/
  
  public String access(HttpServletRequest request) {
		String cardNo = request.getParameter("cardNo");
		Borrower borrower = new Borrower();
		borrower.setCardNo(Integer.parseInt(cardNo));
		
		JDBC jdbc = new JDBC();
		jdbc.access(borrower);
		if(jdbc.access(borrower)==true){
			return "/selectaction2.jsp";
		}else{
			return "/borrower.jsp";
		}
	  }
  
  
//  public void getBooks2(HttpServletRequest request) {
//		int branchId = Integer.parseInt(request.getParameter("branchName"));
//		Branch branch = new Branch();
//		branch.setBranchId(branchId);
//		System.out.println(branchId);
//		
//		JDBC jdbc = new JDBC();
//		jdbc.getBooks2(branch);
//	  }
  
  public void updateBookLoans(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("title"));
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		Book book = new Book();
		book.setBookId(bookId);
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		Borrower borrower = new Borrower();
		borrower.setCardNo(cardNo);
		System.out.println(borrower.getCardNo()+" "+branch.getBranchId()+" "+book.getBookId());
		
		
		JDBC jdbc = new JDBC();
		jdbc.updateBookLoans(book,branch,borrower);
	  }
  
  private void updateBranchName(HttpServletRequest request) {
		String branchName = request.getParameter("branchName");
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		
		JDBC jdbc = new JDBC();
		jdbc.updateBranchName(branch);
	  }
  private void updateBranchAddress(HttpServletRequest request) {
		String branchAddress = request.getParameter("branchAddress");
		Branch branch = new Branch();
		branch.setBranchName(branchAddress);
		
		JDBC jdbc = new JDBC();
		jdbc.updateBranchAddress(branch);
	  }

}
