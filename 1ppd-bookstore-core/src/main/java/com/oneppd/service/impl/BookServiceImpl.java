package com.oneppd.service.impl;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.domain.Book;
import com.oneppd.repository.Repository;
import com.oneppd.service.BookService;

public class BookServiceImpl extends ServiceImpl<Book> implements BookService {

	public BookServiceImpl(Repository<Book> repository) {
		super(repository);
	}

	@Override
	public List<Book> all() throws UndeclaredThrowableException  {
		
		List<Book> books = getRepository().all();
		
		List<Book> composedBooks = new ArrayList<Book>();
		
		for (Book book : books) {
			composedBooks.add(new BookBuilderImpl(book.getUuid()).build());
		}
		
		return composedBooks;
	}

}
