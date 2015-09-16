package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Borrower implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5012546063292632135L;

	private int cardNo;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private List<Book> books;
	
	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	private List<Branch> branches;
}
