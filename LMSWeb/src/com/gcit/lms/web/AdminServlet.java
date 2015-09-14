package com.gcit.lms.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookLoans;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.service.AdministratorService;
import com.gcit.lms.service.BorrowerService;
import com.gcit.lms.service.LibrarianService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet({"/addAuthor", "/updateBranchAddress", "/returnBook", "/updateDetails","/editBorrowers",  "/deleteBranch",  "/editBranch", "/editPublisher", "/addBranch" ,"/editAuthors", "/editBooks", "/editBook",  "/addBooks", "/editAuthor","/checkOut", "/deleteBorrower", "/addCopies", "/addBorrowers", "/deletePublisher", "/selectedBranch2","/deleteBook", "/deleteAuthor", "/addPublisher", "/selectedBranch", "/updateBranchName", "/borrower"})
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
		
	case "/returnBook":
		 System.out.println(request.getParameter("branchId"));
		 System.out.println(request.getParameter("bookId"));
	     //returnBook(request);
	     forwardPath="/showbooks.jsp";
	     break;
		
	case "/deleteBranch":
		deleteBranch(request);
		forwardPath="/library.jsp";
		break;	
		
	case "/deleteBorrower":
		deleteBorrower(request);
		forwardPath="/borrowers.jsp";
		break;
		
	case "/deleteBook":
		deleteBook(request);
		forwardPath="/book.jsp";
		break;
		
	case "/addCopies":
		System.out.println(request.getParameter("branchId"));
		countCopies(request);
		forwardPath = "/addcopies.jsp";
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
			editAuthors(request);
			System.out.println("Rachel");
			forwardPath="/author.jsp";
			break;
			
		case "/editBranch":
			editBranch(request);
			request.setAttribute("editBranchMessage", "Branch Updated Sucessfully");
			forwardPath="/library.jsp";
			break;
			
		case "/editBorrowers":
			editBorrowers(request);
			request.setAttribute("editBorrowersMessage", "Borrower Updated Sucessfully");
			forwardPath="/borrowers.jsp";
			break;
			
		case "/editPublisher":
			editPublishers(request);
			request.setAttribute("editPublisherMessage", "Publisher Updated Sucessfully");
			forwardPath="/publisher.jsp";
			break;	
			
			
		case"/selectedBranch2":
			//getBooks2(request);
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
			
		case "/addBranch":
			addBranch(request);
			request.setAttribute("addBranchMessage", "Branch Added Sucessfully");
			forwardPath = "/library.jsp";
			break;
		
			
		case "/addBorrowers":
			addBorrowers(request);
			request.setAttribute("addBorrowerMessage", "Borrower Added Sucessfully");
			forwardPath = "/borrowers.jsp";
			break;
			
		case "/updateDetails":
			updateDetails(request);
			forwardPath = "/librarian.jsp";
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
			
		
			
		case "/addBooks":
			createBook(request);
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
			
			AdministratorService admin = new AdministratorService();
			try {
				admin.createAuthor(author);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	 
	 private void returnBook(HttpServletRequest request) {
		 int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		 Borrower borrower = new Borrower();
		 borrower.setCardNo(cardNo);
		 int branchId = Integer.parseInt(request.getParameter("branchId"));
		 Branch branch = new Branch();
		 branch.setBranchId(branchId);
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 Book book = new Book();
		 book.setBookId(bookId);
		 BookLoans bookloans = new BookLoans();
		 bookloans.setBorrower(borrower);
		 bookloans.setBranch(branch);
		 bookloans.setBook(book);
		 
		 BorrowerService bor = new BorrowerService();
		 try {
			bor.returnBook(bookloans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private void addBranch(HttpServletRequest request) {
			String branchName = request.getParameter("branchName");
			String branchAddress = request.getParameter("branchAddress");
			Branch branch = new Branch();
			branch.setBranchName(branchName);
			branch.setBranchAddress(branchAddress);
			
			AdministratorService admin = new AdministratorService();
			try {
				admin.createBranch(branch);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
  
  private void editBooks(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		Book book = new Book();
		book.setBookId(bookId);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void editBranch(HttpServletRequest request) {
	    int branchId = Integer.parseInt(request.getParameter("branchId"));
		String branchName = request.getParameter("branchName");
		String branchAddress = request.getParameter("branchAddress");
		
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		branch.setBranchName(branchName);
		branch.setBranchAddress(branchAddress);
		
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updateBranch(branch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  private void editAuthors(HttpServletRequest request) {
	  int authorId = Integer.parseInt(request.getParameter("authorId"));
	  String authorName = request.getParameter("authorName");
		Author author = new Author();
		author.setAuthorName(authorName);
		author.setAuthorId(authorId);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updateAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void editBook(HttpServletRequest request) {
		//String authorName = request.getParameter("authorName");
	    int bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");
		//Author author = new Author();
		Book book = new Book();
		//author.setAuthorName(authorName);
		book.setTitle(title);
		book.setBookId(bookId);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void createBook(HttpServletRequest request) {
		int authorId = Integer.parseInt (request.getParameter("authorId"));
		Author author = new Author();
		author.setAuthorId(authorId);
		AdministratorService admin = new AdministratorService();
		List<Author> authors = new ArrayList<Author>();
		try {
			authors = admin.viewAuthorById(author);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String title = request.getParameter("title");
		
		int pubId = Integer.parseInt (request.getParameter("publisherId"));
		Publisher publisher = new Publisher();
		publisher.setPublisherId(pubId);
		
		Book book = new Book();
		book.setAuthors(authors);
		book.setPublisher(publisher);
		book.setTitle(title);
		
		try {
			admin.createBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void addPublisher(HttpServletRequest request) {
		
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");
		Publisher publisher = new Publisher();
		
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.createPublisher(publisher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void addBorrowers(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Borrower borrower = new Borrower();
		
		borrower.setName(name);
		borrower.setAddress(address);
		borrower.setPhone(phone);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.createBorrower(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void editBorrowers(HttpServletRequest request) {
	    int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		Borrower borrower = new Borrower();
		
		
		borrower.setCardNo(cardNo);
		borrower.setName(name);
		borrower.setAddress(address);
		borrower.setPhone(phone);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updateBorrower(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void editPublishers(HttpServletRequest request) {
	    int publisherId = Integer.parseInt(request.getParameter("publisherId"));
		String publisherName = request.getParameter("publisherName");
		String publisherAddress = request.getParameter("publisherAddress");
		String publisherPhone = request.getParameter("publisherPhone");
		Publisher publisher = new Publisher();
		
		publisher.setPublisherId(publisherId);
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.updatePublisher(publisher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void deleteAuthor(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		System.out.println(authorId);
		Author author = new Author();
		
		author.setAuthorId(Integer.parseInt(authorId));
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.deleteAuthor(author);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void countCopies(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		int copies = Integer.parseInt(request.getParameter("copies"));
		System.out.println(copies);
		
		Book book = new Book();
		book.setBookId(bookId);
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		
		/*JDBC jdbc = new JDBC();
		jdbc.countCopies(book);*/
	  }
  
  private void deleteBorrower(HttpServletRequest request) {
		String cardNo = request.getParameter("cardNo");
		
		Borrower borrower = new Borrower();
		
		borrower.setCardNo(Integer.parseInt(cardNo));
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.deleteBorrower(borrower);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
              
  private void deleteBranch(HttpServletRequest request) {
		String branchId = request.getParameter("branchId");
		
		Branch branch = new Branch();
		
		branch.setBranchId(Integer.parseInt(branchId));
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.deleteBranch(branch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

  
  private void deleteBook(HttpServletRequest request) {
		String bookId = request.getParameter("bookId");
		
		Book book = new Book();
		
		book.setBookId(Integer.parseInt(bookId));
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.deleteBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void deletePublisher(HttpServletRequest request) {
		String publisherId = request.getParameter("publisherId");
		
		Publisher publisher = new Publisher();
		
		publisher.setPublisherId(Integer.parseInt(publisherId));
		
		AdministratorService admin = new AdministratorService();
		try {
			admin.deletePublisher(publisher);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  /*private void editAuthor(HttpServletRequest request) {
		String authorId = request.getParameter("authorId");
		
		Author author = new Author();
		
		author.setAuthorId(Integer.parseInt(authorId));
		
		JDBC jdbc = new JDBC();
		jdbc.editAuthor(author);
	  }*/
  
  public String access(HttpServletRequest request) {
		int cardNo = Integer.parseInt(request.getParameter("cardNo"));
		
		
		
		BorrowerService bor = new BorrowerService();
		int c = 0;
		try {
			bor.access(cardNo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(bor.access(cardNo)==true){
				c = 1;
			}else{
				c = 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(c==1){
			return "/selectaction2.jsp";
		}else{
			return "/borrowers.jsp";
		}
	  }

  
  
  /*public void getBooks2(HttpServletRequest request) {
		int branchId = Integer.parseInt(request.getParameter("branchName"));
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		System.out.println(branchId);
		
		JDBC jdbc = new JDBC();
		jdbc.getBooks2(branch);
	  }*/
  
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
		/*AdministratorService admin = new AdministratorService();
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		List<Branch> branches = new ArrayList<Branch>();
		try {
			branches = admin.viewBranchByBranchId(branch);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}*/
		
		/*List<Borrower> borrowers = new ArrayList<Borrower>();
		try {
			borrowers = admin.viewBorrowerByCardNo(borrower);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		BookLoans bl = new BookLoans();
		bl.setBook(book);
		bl.setBranch(branch);
		bl.setBorrower(borrower);
		
		BorrowerService bor = new BorrowerService();
		try {
			bor.checkOut(bl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  
  private void updateDetails(HttpServletRequest request) {
	  int branchId = Integer.parseInt(request.getParameter("branchId"));
	    String branchAddress = request.getParameter("branchAddress");
		String branchName = request.getParameter("branchName");
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setBranchAddress(branchAddress);
		branch.setBranchId(branchId);
		
		LibrarianService lib = new LibrarianService();
		try {
			lib.updateDetails(branch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  

}
