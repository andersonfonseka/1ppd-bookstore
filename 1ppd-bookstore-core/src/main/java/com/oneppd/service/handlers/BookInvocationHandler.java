package com.oneppd.service.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.oneppd.service.BookService;
import com.oneppd.service.impl.BookServiceImpl;

public class BookInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		BookService bookServiceImpl = new BookServiceImpl();
		Method m = BookServiceImpl.class.getMethod(method.getName(), method.getParameterTypes());
		return m.invoke(bookServiceImpl, args);
	
	}

}
