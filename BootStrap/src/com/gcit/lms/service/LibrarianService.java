package com.gcit.lms.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.domain.Author;
import com.gcit.lms.domain.Book;
import com.gcit.lms.domain.BookCopies;
import com.gcit.lms.domain.Borrower;
import com.gcit.lms.domain.Branch;
import com.gcit.lms.domain.Genre;
import com.gcit.lms.domain.Publisher;
import com.gcit.lms.service.ConnectionUtil;

public class LibrarianService {
	ConnectionUtil connUtil = new ConnectionUtil();
	
	public void updateDetails(Branch branch) throws Exception{
		Connection conn = connUtil.getConnection();
		BranchDAO bdao = new BranchDAO(conn);
		try{
			if(branch.getBranchName()!=null && branch.getBranchAddress()!=null){
			if(branch.getBranchName().length() > 45 && branch.getBranchAddress().length() > 45){
				throw new Exception("Branch Name and Address cannot be more than 45 chars");
			}else{
				bdao.updateBranch(branch);
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
	
	public List<Book> viewBookByBranchId(Branch branch) throws Exception{
		Connection conn = connUtil.getConnection();
		BookDAO bdao = new BookDAO(conn);
		List<Book> book = new ArrayList<Book>();
		try{
			 book = bdao.getBookandCopiesByBranchId(branch);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return book;
	}
	
	public List<BookCopies> viewBookCopiesByBranchId(int branchId)throws Exception{
		Connection conn = connUtil.getConnection();
		BookCopiesDAO bdao = new BookCopiesDAO(conn);
		List<BookCopies> book = new ArrayList<BookCopies>();
		try{
			 book = bdao.getBookandCopiesByBranchId(branchId);
			
			 //conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			//conn.rollback();
		}finally{
			conn.close();
		}return book;
	}
		
	}


