package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8960693747612507680L;

	private int branchId;
	
	private String branchName;
	
	private String branchAddress;
	
	private List<Book> books;
	
	private List<Borrower> borrowers;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
}
