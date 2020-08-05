package com.oneppd.service.impl;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.decorator.BookPrinter;
import com.oneppd.decorator.DecoratorPrinter;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.domain.Book;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> all() throws UndeclaredThrowableException  {
		
		List<Book> books = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY).getBookRepository().all();
		
		for (Book book : books) {
			DecoratorPrinter printer = new PrinterImpl(new BookPrinter(new BookBuilderImpl(book.getUuid()).build()));
			System.out.println(printer.doPrint());
		}
		
		return books;
	}

}
