package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookLoans;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.service.ConnectionUtil;

public class AdministratorService {
	ConnectionUtil connUtil = new ConnectionUtil();

	/* AUTHOR OPERATIONS*/
	
	public void createAuthor(Author author) throws Exception {
		//Boolean flag = validateAuthor(author)
			Connection conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			try{
				if(author.getAuthorName()!=null){
				if(author.getAuthorName().length() > 45){
					throw new Exception("Author Name cannot be more than 45 chars");
				}else{
					adao.createAuthor(author);
					}
				}
				conn.commit();
			}catch(Exception e){
				e.printStackTrace();
				conn.rollback();
			}finally{
				conn.close();
			}
	}
	
	public void updateAuthor(Author author) throws Exception {
		//Boolean flag = validateAuthor(author)
			Connection conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			try{
				if(author.getAuthorName()!=null){
				if(author.getAuthorName().length() > 45){
					throw new Exception("Author Name cannot be more than 45 chars");
				}else{
					adao.updateAuthor(author);
					}
				}
				conn.commit();
			}catch(Exception e){
				e.printStackTrace();
				conn.rollback();
			}finally{
				conn.close();
			}
	}

	public void deleteAuthor(Author author) throws Exception {
		//Boolean flag = validateAuthor(author)
			Connection conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			try{
				 adao.deleteAuthor(author);
				 conn.commit();
				
			}catch(Exception e){
				e.printStackTrace();
				//conn.rollback();
			}finally{
				conn.close();
			}
	}
	
	public List<Author> viewAuthors() throws Exception {
		Connection conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		List<Author> authors = new ArrayList<Author>();
		try{
			 authors = adao.getAllAuthors();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return authors;
	}
	
	public Author viewAuthorById(Author author) throws Exception{
		Connection conn = connUtil.getConnection();
		AuthorDAO adao = new AuthorDAO(conn);
		
		Author author1 = new Author();
		//List<Author> authors = new ArrayList<Author>();
		try{
			 author1 =  adao.getAuthorById(author);
			
			 //conn.commit();
			//authors.add(author1);
;		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return author1;
	}
	
public List<Author> searchAuthor(String search) throws ClassNotFoundException, SQLException {
	Connection conn = connUtil.getConnection();
	AuthorDAO adao = new AuthorDAO(conn);
	try{
		return adao.getAuthorByName(search);
		
		 //conn.commit();
		//authors.add(author1);
		}catch(Exception e){
		e.printStackTrace();
		//conn.rollback();
	}finally{
		conn.close();
	}
		return null;
	}
	
	/*BRANCH OPERATIONS*/
	
	public void createBranch(Branch branch) throws Exception{
		Connection conn = connUtil.getConnection();
		BranchDAO brdao = new BranchDAO(conn);
		try{
			if(branch.getBranchName()!=null && branch.getBranchAddress()!=null){
			if(branch.getBranchName().length() > 45 && branch.getBranchAddress().length() > 45){
				throw new Exception("Branch Name and Branch Address cannot be more than 45 chars");
			}else{
				brdao.createBranch(branch);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void updateBranch(Branch branch) throws Exception{
		Connection conn = connUtil.getConnection();
		BranchDAO brdao = new BranchDAO(conn);
		try{
			if(branch.getBranchName()!=null && branch.getBranchAddress()!=null){
			if(branch.getBranchName().length() > 45 && branch.getBranchAddress().length() > 45){
				throw new Exception("Branch Name and Branch Address cannot be more than 45 chars");
			}else{
				brdao.updateBranch(branch);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void deleteBranch(Branch branch) throws Exception{
		Connection conn = connUtil.getConnection();
		BranchDAO brdao = new BranchDAO(conn);
		try{
			 brdao.deleteBranch(branch);
			 conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Branch> viewBranches() throws Exception {
		Connection conn = connUtil.getConnection();
		BranchDAO brdao = new BranchDAO(conn);
		List<Branch> branches = new ArrayList<Branch>();
		try{
			 branches = brdao.getAllBranch();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return branches;
	}
	
	public Branch viewBranchByBranchId(int branchId) throws Exception{
		Connection conn = connUtil.getConnection();
		BranchDAO bdao = new BranchDAO(conn);
		Branch branches = new Branch();
		
		try{
			 branches= bdao.getBranchByBranchId(branchId);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return branches;
	}
	
	public List<Branch> searchBranch(String search) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		BranchDAO bdao = new BranchDAO(conn);
		try{
			return bdao.getBranchByName(search);
			
			 //conn.commit();
			//authors.add(author1);
			}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
			return null;
		}
	
	/*GENRE OPERATIONS*/
	
	public void createGenre(Genre genre) throws Exception{
		Connection conn = connUtil.getConnection();
		GenreDAO gdao = new GenreDAO(conn);
		try{
			if(genre.getGenre_Name()!=null ){
			if(genre.getGenre_Name().length() > 45){
				throw new Exception("Genre Name cannot be more than 45 chars");
			}else{
				gdao.createGenre(genre);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void updateGenre(Genre genre) throws Exception{
		Connection conn = connUtil.getConnection();
		GenreDAO gdao = new GenreDAO(conn);
		try{
			if(genre.getGenre_Name()!=null ){
			if(genre.getGenre_Name().length() > 45){
				throw new Exception("Genre Name cannot be more than 45 chars");
			}else{
				gdao.updateGenre(genre);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void deleteGenre(Genre genre) throws Exception{
		Connection conn = connUtil.getConnection();
		GenreDAO gdao = new GenreDAO(conn);
		try{
			 gdao.deleteGenre(genre);
			 conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Genre> viewGenres() throws Exception {
		Connection conn = connUtil.getConnection();
		GenreDAO gdao = new GenreDAO(conn);
		List<Genre> genre = new ArrayList<Genre>();
		try{
			 genre = gdao.getAllGenre();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return genre;
	}
	
	/*PUBLISHER OPERATIONS*/
	
	public void createPublisher(Publisher publisher) throws Exception{
		Connection conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		try{
			if(publisher.getPublisherName()!=null && publisher.getPublisherAddress() !=null && publisher.getPublisherPhone() !=null){
			if(publisher.getPublisherName().length() > 45 && publisher.getPublisherAddress().length() > 45 && publisher.getPublisherPhone().length() > 45){
				throw new Exception("Genre Name cannot be more than 45 chars");
			}else{
				pdao.createPublisher(publisher);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void updatePublisher(Publisher publisher) throws Exception{
		Connection conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		try{
			if(publisher.getPublisherName()!=null && publisher.getPublisherAddress() !=null && publisher.getPublisherPhone() !=null){
			if(publisher.getPublisherName().length() > 45 && publisher.getPublisherAddress().length() > 45 && publisher.getPublisherPhone().length() > 45){
				throw new Exception("Genre Name cannot be more than 45 chars");
			}else{
				pdao.updatePublisher(publisher);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void deletePublisher(Publisher publisher) throws Exception{
		Connection conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		try{
				pdao.deletePublisher(publisher);
				conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Publisher> viewPublishers() throws Exception {
		Connection conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		List<Publisher> publisher = new ArrayList<Publisher>();
		try{
			 publisher = pdao.getAllPublisher();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return publisher;
	}
	
	public Publisher viewPublisherById(int publisherId) throws Exception{
		Connection conn = connUtil.getConnection();
		PublisherDAO pdao = new PublisherDAO(conn);
		Publisher publisher1 = new Publisher();
		
		try{
			publisher1 =  pdao.getPublisherById(publisherId);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return publisher1;
	}
	
	public List<Publisher> searchPublisher(String search) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		PublisherDAO bdao = new PublisherDAO(conn);
		try{
			return bdao.getPublisherByName(search);
			
			 //conn.commit();
			//authors.add(author1);
			}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
			return null;
		}
	
	/*BORROWER OPERATIONS*/
	
	public void createBorrower(Borrower borrower) throws Exception{
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		try{
			if(borrower.getName()!=null && borrower.getAddress() !=null && borrower.getPhone() !=null){
			if(borrower.getName().length() > 45 && borrower.getAddress().length() > 45 && borrower.getPhone().length() > 45){
				throw new Exception("Borrower Name, Address and Phone cannot be more than 45 chars");
			}else{
				bdao.createBorrower(borrower);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void updateBorrower(Borrower borrower) throws Exception{
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		try{
			if(borrower.getName()!=null && borrower.getAddress() !=null && borrower.getPhone() !=null){
			if(borrower.getName().length() > 45 && borrower.getAddress().length() > 45 && borrower.getPhone().length() > 45){
				throw new Exception("Borrower Name, Address and Phone cannot be more than 45 chars");
			}else{
				bdao.updateBorrower(borrower);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void deleteBorrower(Borrower borrower) throws Exception{
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		try{
				bdao.deleteBorrower(borrower);
				conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Borrower> viewBorrowers() throws Exception {
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		List<Borrower> borrower = new ArrayList<Borrower>();
		try{
			 borrower = bdao.getAllBorrower();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return borrower;
	}
	
	public Borrower viewBorrowerByCardNo(int cardNo) throws Exception{
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		Borrower borrower1 = new Borrower();
		
		try{
			 borrower1 = bdao.getBorrowerByCardNo(cardNo);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return borrower1;
	}
	
	public List<Borrower> searchBorrower(String search) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		try{
			return bdao.getBorrowerByName(search);
			
			 //conn.commit();
			//authors.add(author1);
			}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
			return null;
		}

/*BOOK OPERATIONS*/
	
	public void createBook(Book book) throws Exception{
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		
		
		try{
			if(book.getTitle()!=null){
			if(book.getTitle().length() > 45){
				throw new Exception("Title cannot be more than 45 chars");
			}else{
				bdao.createBook(book);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void updateBook(Book book) throws Exception{
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		try{
			if(book.getTitle()!=null){
			if(book.getTitle().length() > 45){
				throw new Exception("Title cannot be more than 45 chars");
			}else{
				bdao.updateBook(book);
				}
			}
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public void deleteBook(Book book) throws Exception{
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		try{
				bdao.deleteBook(book);
				conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public List<Book> viewBooks() throws Exception {
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		List<Book> book = new ArrayList<Book>();
		try{
			 book = bdao.getAllBooks();
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return book;
	}

	public Book viewBookByBookId(int bookId) throws Exception{
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		Book books = new Book();
		try{
			 books = bdao.getBookByBookId(bookId);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return books;
	}
	
	public List<Book> searchBook(String search) throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		try{
			return bdao.getBookByName(search);
			
			 //conn.commit();
			//authors.add(author1);
			}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
			return null;
		}
	
	public List<BookLoans> viewLoans() throws ClassNotFoundException, SQLException {
		Connection conn = connUtil.getConnection();
		BookLoansDAO bdao = new BookLoansDAO(conn);
		List<BookLoans> bookloans = new ArrayList<BookLoans>();
		try{
			bookloans = bdao.getAllBookLoans();
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}
			return bookloans;
		
	}
	
	public void dueDate(BookLoans bookloans) throws Exception{
		Connection conn = connUtil.getConnection();
		BookLoansDAO bdao = new BookLoansDAO(conn);
		try{
			
				bdao.updateDueDate(bookloans);
				
	
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}

	


	
}
