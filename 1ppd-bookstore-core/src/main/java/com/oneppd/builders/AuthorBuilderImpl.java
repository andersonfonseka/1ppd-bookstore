package com.oneppd.builders;

import com.oneppd.domain.Author;
import com.oneppd.repository.BookstoreAbstractRepository;

public class AuthorBuilderImpl implements AuthorBuilder {

	private Author author;

	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	public AuthorBuilderImpl(String uuid) {
		this.author = builderAuthor(uuid);
		buildBooks();
	}

	@Override
	public Author builderAuthor(String uuid) {
		return abstractRepository.getAuthorRepository().get(new Author(uuid));
	}

	@Override
	public void buildBooks() {
		this.author.setBooks(abstractRepository.getBookHasAuthorRepository().listByAuthor(this.author));
	}

	@Override
	public Author build() {
		return this.author;
	}
	
}
