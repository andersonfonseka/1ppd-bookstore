package com.oneppd.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oneppd.domain.Book;
import com.oneppd.repository.AbstractRepository;
import com.oneppd.repository.memory.BookRepository;

public class BookRepositoryTest {

	@Test
	public void testAdd() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		assertEquals(((Book) bookRepository.get(book)).getTitle(), "Design Patterns");
	}

	@Test
	public void testUpdate() {

		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
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
	
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
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
	
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
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
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		assertFalse(bookRepository.all().isEmpty());
		
	}

}
