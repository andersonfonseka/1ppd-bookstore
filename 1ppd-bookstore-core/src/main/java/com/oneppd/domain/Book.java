package com.oneppd.domain;

import java.util.List;

public class Book extends Entity {

	private String title;
	
	private Integer edition;
	
	private List<Author> authors;

	public Book() {
		super();
	}

	public Book(String uuid) {
		super(uuid);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
}
