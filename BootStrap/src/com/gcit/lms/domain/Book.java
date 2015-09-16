package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Book implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5088124159768298078L;

	private int bookId;
	
	private String title;
	
	private Publisher publisher;
	
	private List<Borrower> borrowers;
	
	private List<Branch> branches;
	
	public List<Borrower> getBorrowers() {
		return borrowers;
	}

	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenres(List<Genre> genre) {
		this.genre = genre;
	}

	private List<Author> authors;
	
	private List<Genre> genre;
	
	
}
