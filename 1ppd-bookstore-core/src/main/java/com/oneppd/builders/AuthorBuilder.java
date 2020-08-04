package com.oneppd.builders;

import com.oneppd.domain.Author;

public interface AuthorBuilder {

	public Author builderAuthor(String uuid);
	
	public void buildBooks();
	
	public Author build();
	
}
