package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class BookCopies implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5625714713237583850L;

	private Book books;
	
	private Branch branches;
	
	private int noOfCopies;

	public Book getBooks() {
		return books;
	}

	public void setBooks(Book books) {
		this.books = books;
	}

	public Branch getBranches() {
		return branches;
	}

	public void setBranches(Branch branches) {
		this.branches = branches;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

}
