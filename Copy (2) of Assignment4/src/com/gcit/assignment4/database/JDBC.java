package com.gcit.assignment4.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.gcit.assignment4.domain.Author;
import com.gcit.assignment4.domain.Book;
import com.gcit.assignment4.domain.Borrower;
import com.gcit.assignment4.domain.Branch;
import com.gcit.assignment4.domain.Publisher;

public class JDBC {
    int branchId;
    Branch branch = new Branch();
    
	
	public void addAuthor(Author author){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("insert into tbl_author (authorName) values (?)");
			pstmt.setString(1, author.getAuthorName());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addBooks(Author author, Book book){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("insert into tbl_book (title) values(?)");
			pstmt.setString(1, book.getTitle());
			System.out.println(book.getTitle());
			pstmt.executeUpdate();
			//String title = rs.getString("title");
			
			PreparedStatement pstmt1 = getConnection().prepareStatement("Select bookId from tbl_book where title=?");
			pstmt1.setString(1, book.getTitle());
			System.out.println(book.getTitle());
			ResultSet rs1 = pstmt1.executeQuery();
			rs1.next();
			int bookId = rs1.getInt("bookId");
			
			PreparedStatement pstmt2 = getConnection().prepareStatement("Insert into tbl_book_authors values(?,?)");
			pstmt2.setInt(1, bookId);
			pstmt2.setInt(2, author.getAuthorId());
			pstmt2.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Book editBooks(Book book){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select title from tbl_book where bookId=?");
			pstmt.setInt(1, book.getBookId());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			book.setTitle( rs.getString("title"));
			
			
			/*PreparedStatement pstmt1 = getConnection().prepareStatement("select authorName from tbl_author join tbl_book_authors on tbl_author.authorId=tbl_book_authors.authorId where bookId=?");
			pstmt1.setInt(1, book.getBookId());
			//System.out.println(title);
			ResultSet rs1 = pstmt1.executeQuery();
			rs.next();
			
			author.setAuthorName(rs.getString("authorName"));*/
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}return book;
	}
	
	public void editBook(Book book){
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("update tbl_book set title=? where bookId=?");
			pstmt.setString(1, book.getTitle());
			pstmt.setInt(2, book.getBookId());
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Author editAuthors(Author author){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select authorName from tbl_author where authorId=?");
			pstmt.setInt(1, author.getAuthorId());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			author.setAuthorName( rs.getString("authorName"));
			
			
			/*PreparedStatement pstmt1 = getConnection().prepareStatement("select authorName from tbl_author join tbl_book_authors on tbl_author.authorId=tbl_book_authors.authorId where bookId=?");
			pstmt1.setInt(1, book.getBookId());
			//System.out.println(title);
			ResultSet rs1 = pstmt1.executeQuery();
			rs.next();
			
			author.setAuthorName(rs.getString("authorName"));*/
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}return author;
	}
	
	
public void editAuthor(Author author){
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("update tbl_author set authorName=? where authorId=?");
			pstmt.setString(1, author.getAuthorName());
			pstmt.setInt(2, author.getAuthorId());
			
			pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public Borrower editBorrowers(Borrower borrower){
	try {
		PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_borrower where cardNo=?");
		pstmt.setInt(1, borrower.getCardNo());
		
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		borrower.setName( rs.getString("name"));
		borrower.setAddress( rs.getString("address"));
		borrower.setPhone( rs.getString("phone"));
		
		
		/*PreparedStatement pstmt1 = getConnection().prepareStatement("select authorName from tbl_author join tbl_book_authors on tbl_author.authorId=tbl_book_authors.authorId where bookId=?");
		pstmt1.setInt(1, book.getBookId());
		//System.out.println(title);
		ResultSet rs1 = pstmt1.executeQuery();
		rs.next();
		
		author.setAuthorName(rs.getString("authorName"));*/
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}return borrower;
}


public void editBorrower(Borrower borrower){
	
	try {
		PreparedStatement pstmt = getConnection().prepareStatement("update tbl_borrower set name=?, address=?, phone=? where cardNo=?");
		pstmt.setString(1, borrower.getName());
		pstmt.setString(2, borrower.getAddress());
		pstmt.setString(3, borrower.getPhone());
		pstmt.setInt(4, borrower.getCardNo());
		
		pstmt.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	
	public void addPublisher(Publisher publisher){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?,?,?)");
			
			pstmt.setString(1, publisher.getPublisherName());
			pstmt.setString(2, publisher.getPublisherAddress());
			pstmt.setString(3, publisher.getPublisherPhone());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addBorrowers(Borrower borrower){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("insert into tbl_borrower (name, address, phone) values (?,?,?)");
			
			pstmt.setString(1, borrower.getName());
			pstmt.setString(2, borrower.getAddress());
			pstmt.setString(3, borrower.getPhone());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Author> getAuthors(){
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_author");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Author a = new Author();
				a.setAuthorId(rs.getInt("authorId"));
				a.setAuthorName(rs.getString("authorName"));
				
				authors.add(a);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}
	
	public List<Book> getBooks(){
		
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_book");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Book k = new Book();
				k.setBookId(rs.getInt("bookId"));
				k.setTitle(rs.getString("title"));
				
				books.add(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public List<Book> getBooks2(Branch branch){
		List<Book> books = new ArrayList<Book>();
		
		try {
			
			
			PreparedStatement pstmt1 = getConnection().prepareStatement("select * from tbl_book join tbl_book_copies on tbl_book.bookId=tbl_book_copies.bookId where noOfCopies>=1 and branchId=?");
			pstmt1.setInt(1, branch.getBranchId());
			//System.out.println(branch.getBranchId());
			ResultSet rs1 = pstmt1.executeQuery();
			
			
			while(rs1.next()){
				Book k = new Book();
				
				k.setTitle(rs1.getString("title"));
				k.setBookId(rs1.getInt("bookId"));
				books.add(k);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	public List<Publisher> getPublishers(){
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_publisher");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Publisher p = new Publisher();
				p.setPublisherId(rs.getInt("publisherId"));
				p.setPublisherName(rs.getString("publisherName"));
				p.setPublisherAddress(rs.getString("publisherAddress"));
				p.setPublisherPhone(rs.getString("publisherPhone"));
				
				publishers.add(p);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishers;
	}
	
	public List<Borrower> getBorrowers(){
		List<Borrower> borrowers = new ArrayList<Borrower>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_borrower");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Borrower l = new Borrower();
				l.setCardNo(rs.getInt("cardNo"));
				l.setName(rs.getString("name"));
				l.setAddress(rs.getString("address"));
				l.setPhone(rs.getString("phone"));
				
				borrowers.add(l);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return borrowers;
	}
	
	public void deleteAuthor(Author author){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Delete from tbl_author where authorId=?");
			pstmt.setInt(1, author.getAuthorId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(Book book){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Delete from tbl_book where bookId=?");
			pstmt.setInt(1, book.getBookId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePublisher(Publisher publisher){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Delete from tbl_publisher where publisherId=?");
			pstmt.setInt(1, publisher.getPublisherId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBorrower(Borrower borrower){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Delete from tbl_borrower where cardNo=?");
			pstmt.setInt(1, borrower.getCardNo());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBookLoans(Book book, Branch branch, Borrower borrower){
		try {
			
			PreparedStatement pstmt1 = getConnection().prepareStatement("insert into tbl_book_loans (bookId,cardNo, branchId, dateOut, dueDate) values(?,?,?,now(),now()+7) ");
			pstmt1.setInt(1, borrower.getCardNo());
			pstmt1.setInt(2, book.getBookId());
			pstmt1.setInt(3, branch.getBranchId());
			
			pstmt1.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
/*	public void editAuthor(Author author){
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Update tbl_author set authorName=?");
			pstmt.setInt(1, author.getAuthorId());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public boolean access(Borrower borrower){
		int count=0;
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Select name from tbl_borrower where cardNo=?");
			pstmt.setInt(1, borrower.getCardNo());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
			count++;
			}else{
				count=0;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		if(count==1){
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public List<Branch> selectBranch(){
		List <Branch> branches = new ArrayList<Branch>();
		try{
			PreparedStatement pstmt = getConnection().prepareStatement("select * from tbl_library_branch");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Branch b = new Branch();
				b.setBranchId(rs.getInt("branchId"));
				b.setBranchName(rs.getString("branchName"));
				
				branches.add(b);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return branches;
	}
	
    public void selectedBranch(Branch branch){
    	
    	try {
    		System.out.println("Rachel");
			PreparedStatement pstmt = getConnection().prepareStatement("Select branchId from tbl_library_branch where branchName=?");
			pstmt.setString(1, branch.getBranchName());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			branchId = rs.getInt("branchId");
			System.out.println(branchId); 
			branch.setBranchId(branchId);
			System.out.println(branch.getBranchId());
			pstmt.executeQuery();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
	}
    
    public int countCopies(Book book){
    	int copies=0;
		try {
			PreparedStatement pstmt = getConnection().prepareStatement("Select bookId from tbl_book where title=?");
			pstmt.setString(1, book.getTitle());
			ResultSet rs = pstmt.executeQuery();
			int bookId = rs.getInt("bookId");
			
			
			PreparedStatement pstmt1 = getConnection().prepareStatement("Select count(noOfCopies) from tbl_book_copies where bookId='"+bookId+"' and branchId='"+branch.getBranchId()+"'");
			//pstmt.setString(1, author.getAuthorName());
			ResultSet rs1 = pstmt1.executeQuery();
			copies= rs1.getInt("count(noOfCopies)");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return copies;
	}
    
	
    public void selectedBranch2(Branch branch){
    	try {
			PreparedStatement pstmt = getConnection().prepareStatement("Select branchId from tbl_library_branch where branchName=?");
			pstmt.setString(1, branch.getBranchName());
			ResultSet rs = pstmt.executeQuery(); 
			branchId = rs.getInt("branchId");
			System.out.println(branchId);
			pstmt.executeQuery();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public void updateBranchName (Branch branch){
    	try {
    		 
			PreparedStatement pstmt = getConnection().prepareStatement("Update tbl_library_branch set branchName=? where branchId=?");
			pstmt.setString(1, branch.getBranchName());
			pstmt.setInt(2, branch.getBranchId());
			System.out.println(branch.getBranchName());
			System.out.println(branch.getBranchId());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    public void updateBranchAddress (Branch branch){
    	try {
			PreparedStatement pstmt = getConnection().prepareStatement("Update tbl_library_branch set branchAddress=? where branchId='"+branchId+"'");
			pstmt.setString(1, branch.getBranchAddress());
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "admin");
		return conn;
	}
}

