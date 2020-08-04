package com.oneppd.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.domain.Book;

public class BookFlyweight {

	private static BookFlyweight INSTANCE;
	
	private Map<String, Book> map = new ConcurrentHashMap<String, Book>();
	
	private BookFlyweight() {}
	
	public static BookFlyweight getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookFlyweight();
		}
		return INSTANCE;
	}

	public Book getBook(Book pBook) {

		if (map.containsKey(pBook.getUuid())) {
			return map.get(pBook.getUuid());
		}

		Book book = new BookBuilderImpl(pBook.getUuid()).build();
		
		map.put(book.getUuid(), book);

		return book;
	}

}
