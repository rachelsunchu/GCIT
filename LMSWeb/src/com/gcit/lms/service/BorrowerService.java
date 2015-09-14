package com.gcit.lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookLoans;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;

public class BorrowerService {
	ConnectionUtil connUtil = new ConnectionUtil();

	public boolean access(int cardNo) throws ClassNotFoundException, SQLException{
		Connection conn = connUtil.getConnection();
		BorrowerDAO bdao = new BorrowerDAO(conn);
		Borrower borrower = new Borrower();
		borrower = bdao.getBorrowerByCardNo(cardNo);
		if(borrower.getName()!=null)
				return true;
		return false;
	
   }
   
   public List<Branch> getAllBranches() throws Exception{
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
   
   public List<BookLoans> showBooks(int cardNo) throws Exception{
	   Connection conn = connUtil.getConnection();
	   BookLoansDAO bdao = new BookLoansDAO(conn);
	   List<BookLoans> bl = new ArrayList<BookLoans>();
	   try{
			 bl = bdao.showBooks(cardNo);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return bl;
   }
   
   public List<Book> getAllBooksByBranchId(Branch branch) throws Exception{
	   Connection conn = connUtil.getConnection();
	   BookDAO bdao = new BookDAO(conn);
	   List<Book> books = new ArrayList<Book>();
	   try{
			 books = bdao.getBookByBranchId(branch);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return books;
   }
   
   public void checkOut(BookLoans bookloans)throws Exception{
	   
	   Connection conn = connUtil.getConnection();
	   BookLoansDAO bldao = new BookLoansDAO(conn);
	   try{
		   bldao.checkOut(bookloans);
		   conn.commit();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   conn.close();
	   }
   }
   
   public void returnBook(BookLoans bookloans)throws Exception{
	   Connection conn = connUtil.getConnection();
	   BookLoansDAO bdao = new BookLoansDAO(conn);
	   try{
		   bdao.returnBook(bookloans);
		   conn.commit();
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   conn.close();
	   }
   }


}