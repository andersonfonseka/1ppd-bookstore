package com.oneppd.service;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

import com.oneppd.domain.Book;

public interface BookService {
	
	public List<Book> all() throws UndeclaredThrowableException;
	
}
