package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookCopies;
import com.gcit.lms.dao.BookDAO;


public class BookCopiesDAO extends BaseDAO {
	
	public BookCopiesDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public List<BookCopies> getAllBookCopies() throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_book_copies", null);
	}
	
	public List<BookCopies> getBookandCopiesByBranchId(int branchId) throws ClassNotFoundException, SQLException {
		return readFirstLevel("select * from tbl_book_copies where branchId=?", new Object[] {branchId});
	}
	
	public List<BookCopies> getAllBookCopiesByBookId(Book book) throws ClassNotFoundException, SQLException {
		return readAll("select * from tbl_book_copies where bookId=?", new Object[] { book.getBookId() });
	}

	@Override
	public List extractData(ResultSet rs) {
		return null;
	}
	
	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<BookCopies> books = new ArrayList<BookCopies>();
		BookCopiesDAO pdao = new BookCopiesDAO(conn);
		BookDAO bdao = new BookDAO(conn);
		BranchDAO brdao = new BranchDAO(conn);
		try {
			while (rs.next()) {
				BookCopies b = new BookCopies();

				b.setBooks(bdao.getBookByBookId(rs.getInt("bookId")));

				b.setBranches(brdao.getBranchByBranchId(rs.getInt("branchId")));
				
				b.setNoOfCopies(rs.getInt("noOfCopies"));

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
