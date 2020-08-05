package com.oneppd.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

import com.oneppd.service.impl.BookInvocationHandler;

public class ServiceFactory {
	
	public Service getService(Class serviceClass) throws UndeclaredThrowableException {
		
		InvocationHandler handler = new BookInvocationHandler();
		Service bookService = (Service) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[] { serviceClass }, handler);
		return bookService;
	}

}
