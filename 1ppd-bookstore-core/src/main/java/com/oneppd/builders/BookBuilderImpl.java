package com.oneppd.builders;

import com.oneppd.domain.Book;
import com.oneppd.repository.AbstractRepository;

public class BookBuilderImpl implements BookBuilder {

	private Book book;

	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	public BookBuilderImpl(String uuid) {
		this.book = builderBook(uuid);
		buildAuthors();
	}

	public Book builderBook(String uuid) {
		return (Book) abstractRepository.getBookRepository().get(new Book(uuid));
	}

	public void buildAuthors() {
		this.book.setAuthors(abstractRepository.getBookHasAuthorRepository().listByBook(this.book));
	}

	public Book build() {
		return book;
	}
	
}
