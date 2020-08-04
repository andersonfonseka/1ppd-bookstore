package com.oneppd.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

public class ServiceFactory {
	
	public BookService getBookService() throws UndeclaredThrowableException {
		
		InvocationHandler handler = new BookInvocationHandler();
		BookService bookService = (BookService) Proxy.newProxyInstance(BookServiceImpl.class.getClassLoader(), new Class<?>[] { BookService.class }, handler);
		return bookService;
	}

}
