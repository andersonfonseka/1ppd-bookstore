package com.oneppd.service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import com.oneppd.domain.Book;

public interface BookService extends Service<Book> {
	
	public List<Book> all() throws UndeclaredThrowableException;
	
}
