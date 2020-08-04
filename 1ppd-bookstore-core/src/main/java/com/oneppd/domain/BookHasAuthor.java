package com.oneppd.domain;

public class BookHasAuthor extends Entity {
	
	private Book book;
	
	private Author author;
	
	public BookHasAuthor(Book book, Author author) {
		super();
		this.book = book;
		this.author = author;
	}

	public Book getBook() {
		return book;
	}

	public Author getAuthor() {
		return author;
	}
	
}
