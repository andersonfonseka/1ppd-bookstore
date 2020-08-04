package com.oneppd.test;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.builders.CatalogBuilderImpl;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.domain.Catalog;
import com.oneppd.domain.Price;
import com.oneppd.repository.AbstractRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CatalogRepository;
import com.oneppd.repository.memory.PriceRepository;

public class CatalogTest {

	@Test
	public void testAdd() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
		CatalogRepository catalogRepository = abstractRepository.getCatalogRepository();
		
		Catalog catalog = new Catalog();
		
		List<Book> books = new ArrayList<Book>();
		books.add(getBook());
		books.add(getBook2());
		
		catalog.setName("Computer Science");
		catalog.setBooks(books);
				
		catalogRepository.add(catalog);
		
		assertFalse(catalogRepository.all().isEmpty());
		
	}
	
	@Test
	public void testCatalogBuilder() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
		CatalogRepository catalogRepository = abstractRepository.getCatalogRepository();
		
		Catalog catalog = new Catalog();
		
		List<Book> books = new ArrayList<Book>();
		books.add(getBook());
		books.add(getBook2());
		
		catalog.setName("Computer Science");
		catalog.setBooks(books);
				
		catalogRepository.add(catalog);
		
		Catalog catalogBuilder = new CatalogBuilderImpl(catalog.getUuid()).build();
		
		assertFalse(catalogBuilder.getBooks().isEmpty());
		
	}
	
	private Book getBook() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
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
	
	private Book getBook2() {
		
		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		AuthorRepository authorRepository = abstractRepository.getAuthorRepository();
		BookHasAuthorRepository bookHasAuthorRepository = abstractRepository.getBookHasAuthorRepository();
		
		Book book = new Book();
		book.setTitle("Clean Architecture: A Craftsman's Guide to Software Structure and Design");
		book.setEdition(1);
		
		bookRepository.add(book);
		
		Author author1 = new Author();
		author1.setName("Robert C. Martin");
		
		authorRepository.add(author1);
		
		bookHasAuthorRepository.add(new BookHasAuthor(book, author1));
		
		PriceRepository priceRepository = abstractRepository.getPriceRepository();

		Price price0 = new Price(book, 25.83, new GregorianCalendar(2020, 6, 1), new GregorianCalendar(2020, 6, 30));
		Price price1 = new Price(book, 28.00, new GregorianCalendar(2020, 7, 1), new GregorianCalendar(2020, 7, 30));
		Price price2 = new Price(book, 35.00, new GregorianCalendar(2020, 8, 1), new GregorianCalendar(2020, 8, 30));

		priceRepository.add(price0);
		priceRepository.add(price1);
		priceRepository.add(price2);
		
		return new BookBuilderImpl(book.getUuid()).build();
		
	}

	
}
