package com.oneppd.repository.memory;

import com.oneppd.domain.Book;

public class BookRepository extends BaseRepository<Book> {

	private static BookRepository INSTANCE;
	
	public static BookRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookRepository();
		}

		return INSTANCE;
	}
	
	
	private BookRepository() {}
	
}
