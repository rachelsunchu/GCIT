package com.gcit.lms.domain;

import java.io.Serializable;
import java.util.List;

public class Genre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5150306380183248718L;

	private int genre_Id;
	
	private String genre_Name;
	
	private List<Book> books;

	public int getGenre_Id() {
		return genre_Id;
	}

	public void setGenre_Id(int genreId) {
		this.genre_Id = genreId;
	}

	public String getGenre_Name() {
		return genre_Name;
	}

	public void setGenre_Name(String genreName) {
		this.genre_Name = genreName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

}
