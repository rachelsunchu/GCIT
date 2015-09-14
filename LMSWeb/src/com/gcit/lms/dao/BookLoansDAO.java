package com.gcit.lms.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookLoans;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;

public class BookLoansDAO extends BaseDAO{
	
	public BookLoansDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public List<BookLoans> showBooks(int cardNo) throws ClassNotFoundException, SQLException{
		return readAll("select * from tbl_book_loans where cardNo=? and dateIn is null", new Object[] {cardNo});
	}
	
    public void checkOut(BookLoans bookloans)throws ClassNotFoundException, SQLException{
		 
		
		save("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) values(?,?,?,CURDATE(),CURDATE()+INTERVAL 7 Day)",
				new Object[] {bookloans.getBook().getBookId(), bookloans.getBranch().getBranchId() , bookloans.getBorrower().getCardNo() });
		
		save("update tbl_book_copies set noOfCopies=noOfCopies-1 where bookId=? and branchId=?", new Object[] { bookloans.getBook().getBookId(), bookloans.getBranch().getBranchId()});
	  }

	public void returnBook(BookLoans bookloans)throws ClassNotFoundException, SQLException {
		save("update tbl_book_loans set dateIn=CURDATE() where cardNo=?, branchId=? and bookId=?",
				new Object[] {bookloans.getBorrower().getCardNo(), bookloans.getBranch().getBranchId(), bookloans.getBook().getBookId() });

	}


	@Override
	public List<?> extractData(ResultSet rs) {
	    List<BookLoans> bookloans = new ArrayList<BookLoans>();
		BorrowerDAO bdao = new BorrowerDAO(conn);
        BranchDAO brdao = new BranchDAO(conn);
        BookDAO bodao = new BookDAO(conn);
	    try{
	    	while(rs.next()){
	    		BookLoans bl = new BookLoans();
	    		
	    		bl.setDateIn(rs.getString("dateIn"));
	    		bl.setDateOut(rs.getString("dateOut"));
	    		bl.setDueDate(rs.getString("dueDate"));
	    	    bl.setBorrower(bdao.getBorrowerByCardNo(rs.getInt("cardNo")));
	    	    bl.setBranch(brdao.getBranchByBranchId(rs.getInt("branchId")));
	    	    bl.setBook(bodao.getBookByBookId(rs.getInt("bookId")));
	    		
	    	    
	    		bookloans.add(bl);
	    	}
	    } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	    
	  return bookloans;
	}
	
	


	@Override
	public List extractDataFirstLevel(ResultSet rs) {
		List<BookLoans> bookloans = new ArrayList<BookLoans>();
		BorrowerDAO bdao = new BorrowerDAO(conn);
        BranchDAO brdao = new BranchDAO(conn);
        BookDAO bodao = new BookDAO(conn);
	    try{
	    	while(rs.next()){
	    		BookLoans bl = new BookLoans();
	    		
	    		bl.setDateIn(rs.getString("dateIn"));
	    		bl.setDateOut(rs.getString("dateOut"));
	    		bl.setDueDate(rs.getString("dueDate"));
	    	    
	    				
	    		bookloans.add(bl);
	    	}
	    } catch (SQLException e) {
			e.printStackTrace();
		}		
	    
	  return bookloans;

	}
}
