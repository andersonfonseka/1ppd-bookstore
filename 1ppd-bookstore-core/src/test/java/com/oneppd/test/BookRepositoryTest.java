package com.oneppd.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oneppd.domain.Book;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.memory.BookRepository;

public class BookRepositoryTest {

	@Test
	public void testAdd() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		assertEquals(((Book) bookRepository.get(book)).getTitle(), "Design Patterns");
	}

	@Test
	public void testUpdate() {

		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);

		book = (Book) bookRepository.get(book);
		book.setTitle("Clean Architecture");
		
		bookRepository.update(book);
		
		assertNotEquals(((Book) bookRepository.get(book)).getTitle(), "Design Patterns");
	
	}

	@Test
	public void testRemove() {
	
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		bookRepository.remove(book);
		
		assertTrue(bookRepository.get(book) == null);
	}

	@Test
	public void testGet() {
	
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);

		book = (Book) bookRepository.get(book);
		
		assertNotNull(book);
	}

	@Test
	public void testAll() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		assertFalse(bookRepository.all().isEmpty());
		
	}

}
