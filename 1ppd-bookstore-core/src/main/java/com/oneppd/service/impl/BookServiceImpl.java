package com.oneppd.service.impl;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.domain.Book;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> all() throws UndeclaredThrowableException  {
		
		List<Book> books = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY).getBookRepository().all();
		
		List<Book> composedBooks = new ArrayList<Book>();
		
		for (Book book : books) {
			composedBooks.add(new BookBuilderImpl(book.getUuid()).build());
		}
		
		return composedBooks;
	}

}
