package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Publisher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288472868644111227L;

	private int publisherId;
	
	private String publisherName;
	
	private String publisherPhone;
	
	
	public String getPublisherPhone() {
		return publisherPhone;
	}

	public void setPublisherPhone(String publisherPhone) {
		this.publisherPhone = publisherPhone;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherAddress() {
		return publisherAddress;
	}

	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	private String publisherAddress;
	
	private List<Book> books;
    	
}
