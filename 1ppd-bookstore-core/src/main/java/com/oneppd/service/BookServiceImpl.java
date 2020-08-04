package com.oneppd.service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.decorator.BookPrinter;
import com.oneppd.decorator.Printer;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.domain.Book;
import com.oneppd.repository.AbstractRepository;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> all() throws UndeclaredThrowableException  {
		
		List<Book> books = AbstractRepository.getRepository(AbstractRepository.MEMORY).getBookRepository().all();
		
		for (Book book : books) {
			Printer printer = new PrinterImpl(new BookPrinter(new BookBuilderImpl(book.getUuid()).build()));
			System.out.println(printer.doPrint());
		}
		
		return books;
	}

}
