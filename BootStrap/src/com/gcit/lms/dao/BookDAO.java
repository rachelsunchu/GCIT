package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookCopies;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;

public class BookDAO extends BaseDAO {

	public BookDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public void createBook(Book book) throws ClassNotFoundException, SQLException {
		int bookId = saveWithID("insert into tbl_book (title, pubId) values(?, ?)",
				new Object[] { book.getTitle(), book.getPublisher().getPublisherId() });

		for (Author a : book.getAuthors()) {
			save("insert into tbl_book_authors (bookId, authorId) values (?,?)",
					new Object[] { bookId, a.getAuthorId() });
		}

		/*for (Genre g : book.getGenre()) {
			save("insert into tbl_book_genres (bookId, genreId) values (?,?)",
					new Object[] { bookId, g.getGenre_Id() });
		}*/

	}

	public void updateBook(Book book) throws ClassNotFoundException, SQLException {
		save("update tbl_book set title = ? where bookId=?", new Object[] { book.getTitle(), book.getBookId() });
	}

	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book where bookId=?", new Object[] { book.getBookId() });
	}

	
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
		return readFirstLevel("select * from tbl_book", null);
	}

	public Book getBookByBookId(int bookId) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<Book>();
		books = readFirstLevel("select * from tbl_book where bookId = ?", new Object[] { bookId });

		if (books != null && books.size() > 0) {
			return books.get(0);
		}
		return null;
	}

	public List<Book> getBookByBranchId(Branch branch) throws ClassNotFoundException, SQLException {
		return readFirstLevel(
				"select * from tbl_book join tbl_book_copies on tbl_book.bookId=tbl_book_copies.bookId where noOfCopies>=1 and branchId=?",
				new Object[] { branch.getBranchId() });
	}

	public List<Book> getBookandCopiesByBranchId(Branch branch) throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_book_copies, tbl_book where branchId=?", new Object[] { branch.getBranchId() });
	}

	public Book getBookByTitle(Book book) throws ClassNotFoundException, SQLException {
		List<Book> books = new ArrayList<Book>();
		books = readAll("select * from tbl_book where title = ?", new Object[] { book.getTitle() });

		if (books != null && books.size() > 0) {
			return books.get(0);
		}
		return null;
	}
	
	public List<Book> getBookByName(String search) throws ClassNotFoundException, SQLException {
		search = "%"+search+"%";
		
		return readFirstLevel("select * from tbl_book where title like ?", new Object[] {search});
	}

	@Override
	public List<?> extractData(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
        PublisherDAO pdao = new PublisherDAO(conn);
		AuthorDAO adao= new AuthorDAO(conn);
        GenreDAO gdao = new GenreDAO(conn);
        BorrowerDAO bdao = new BorrowerDAO(conn);
        BranchDAO brdao = new BranchDAO(conn);
        try {
			while (rs.next()) {
				Book bk = new Book();
				
				bk.setBookId(rs.getInt("bookId"));
				bk.setTitle(rs.getString("title"));
				bk.setPublisher(pdao.getPublisherById(rs.getInt("pubId")));
				
				List<Author> authors = (List<Author>) adao.readFirstLevel(
					"select * from tbl_author where authorId in (select authorId from tbl_book_authors where bookId=?)",
					new Object[] {bk.getBookId()});
				bk.setAuthors(authors);
				
				List<Genre> genres = (List<Genre>) gdao.readFirstLevel(
						"select * from tbl_genre where genre_id in (select genre_id from tbl_book_genres where bookId=?)",
						new Object[] {bk.getBookId()});
				bk.setGenres(genres);
				
				List<Borrower> borrowers = (List<Borrower>) bdao.readFirstLevel(
						"select * from tbl_borrower where cardNo in (select cardNo from tbl_book_loans where bookId=?)",
						new Object[] {bk.getBookId()});
				bk.setBorrowers(borrowers);
				
				List<Branch> branches = (List<Branch>) brdao.readFirstLevel(
						"select * from tbl_library_branch where branchId in (select brancdId from tbl_book_loans where bookId=?)",
						new Object[] {bk.getBookId()});
				bk.setBranches(branches);

				books.add(bk);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<Book> books = new ArrayList<Book>();
		PublisherDAO pdao = new PublisherDAO(conn);
		try {
			while (rs.next()) {
				Book b = new Book();

				b.setBookId(rs.getInt("bookId"));

				b.setTitle(rs.getString("title"));
				
				b.setPublisher(pdao.getPublisherById(rs.getInt("pubId")));

				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}
