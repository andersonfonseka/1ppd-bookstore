package com.oneppd.test;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.builders.ShoppingCartBuilderImpl;
import com.oneppd.decorator.CustomerPrinter;
import com.oneppd.decorator.DecoratorPrinter;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.decorator.ShoppingCartPrinter;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.domain.Customer;
import com.oneppd.domain.Item;
import com.oneppd.domain.Price;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public class ShoppingCartTest {

	@Test
	public void testAdd() {

		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);

		CustomerRepository customerRepository = abstractRepository.getCustomerRepository();
		ShoppingCartRepository shoppingCartRepository = abstractRepository.getShoppingCartRepository();
		ItemRepository itemRepository = abstractRepository.getItemRepository();

		Customer customer = new Customer();
		customer.setFirstName("Anderson");
		customer.setLastName("Silva");
		customer.setNickName("Anderson Fonseca");
		
		DecoratorPrinter cusPrinter = new PrinterImpl(new CustomerPrinter(customer));
		System.out.println(cusPrinter.doPrint());

		customerRepository.add(customer);

		ShoppingCart shoppingCart = new ShoppingCart(customer);
		shoppingCartRepository.add(shoppingCart);

		Book bookTest =  getBook();
		
		itemRepository.add(new Item(shoppingCart, bookTest, 1));
		itemRepository.add(new Item(shoppingCart, getBook2(), 1));
		itemRepository.add(new Item(shoppingCart, bookTest, 1));

		ShoppingCart composedShoppingCart = new ShoppingCartBuilderImpl(shoppingCart.getUuid()).build();

		DecoratorPrinter printer = new PrinterImpl(new ShoppingCartPrinter(composedShoppingCart));
		System.out.println(printer.doPrint());
		
		assertNotNull(composedShoppingCart);

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
	
	private Book getBook2() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
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
