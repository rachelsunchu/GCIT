package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class BookLoans implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -235274413497093924L;

	private Book book;
	
	private Branch branch;
	
	private Borrower borrower;
	
	private String dateOut;
	
	private String dueDate;
	
	private String dateIn;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public String getDateOut() {
		return dateOut;
	}

	public void setDateOut(String dateOut) {
		this.dateOut = dateOut;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDateIn() {
		return dateIn;
	}

	public void setDateIn(String dateIn) {
		this.dateIn = dateIn;
	}
	

}
