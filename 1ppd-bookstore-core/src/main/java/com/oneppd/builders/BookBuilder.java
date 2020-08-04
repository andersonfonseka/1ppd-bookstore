package com.oneppd.builders;

import com.oneppd.domain.Book;

public interface BookBuilder {

	public Book builderBook(String uuid);
	
	public void buildAuthors();
	
	public Book build();

	void buildPrice();
	
}
