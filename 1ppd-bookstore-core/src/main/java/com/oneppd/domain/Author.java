package com.oneppd.domain;

import java.util.List;

public class Author extends Entity {
	
	private String name;
	
	private List<Book> books;
	
	public Author() {
		super();
	}

	public Author(String uuid) {
		super(uuid);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
