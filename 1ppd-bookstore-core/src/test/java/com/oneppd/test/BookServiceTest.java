package com.oneppd.test;

import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.domain.Price;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.service.BookService;
import com.oneppd.service.ServiceFactory;
import com.oneppd.service.impl.BookInvocationHandler;

public class BookServiceTest {

	@Test
	public void testService() {
		
		getBook();
		
		BookService bookService = (BookService) new ServiceFactory().getService(BookService.class, new BookInvocationHandler());
		
		List<Book> books = bookService.all();
		
		assertTrue(!books.isEmpty());
	}

	
	private Book getBook() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		AuthorRepository authorRepository = abstractRepository.getAuthorRepository();
		BookHasAuthorRepository bookHasAuthorRepository = abstractRepository.getBookHasAuthorRepository();
		
		Book book = new Book();
		book.setTitle("Design Patterns");
		book.setEdition(20);
		
		bookRepository.add(book);
		
		Author author1 = new Author();
		author1.setName("Erich Gamma");
		
		Author author2 = new Author();
		author2.setName("Richard Helm");
		
		Author author3 = new Author();
		author3.setName("Ralph Johnson");
		
		Author author4 = new Author();
		author4.setName("John Vlissides");
		
		authorRepository.add(author1);
		authorRepository.add(author2);
		authorRepository.add(author3);
		authorRepository.add(author4);
		
		bookHasAuthorRepository.add(new BookHasAuthor(book, author1));
		bookHasAuthorRepository.add(new BookHasAuthor(book, author2));
		bookHasAuthorRepository.add(new BookHasAuthor(book, author3));
		bookHasAuthorRepository.add(new BookHasAuthor(book, author4));
		
		PriceRepository priceRepository = abstractRepository.getPriceRepository();

		Price price0 = new Price(book, 50.00, new GregorianCalendar(2020, 6, 1), new GregorianCalendar(2020, 6, 30));
		Price price1 = new Price(book, 55.00, new GregorianCalendar(2020, 7, 1), new GregorianCalendar(2020, 7, 30));
		Price price2 = new Price(book, 60.00, new GregorianCalendar(2020, 8, 1), new GregorianCalendar(2020, 8, 30));

		priceRepository.add(price0);
		priceRepository.add(price1);
		priceRepository.add(price2);
		
		return new BookBuilderImpl(book.getUuid()).build();
		
	}
	
}
