package com.oneppd.test;

import org.junit.Test;

import static org.junit.Assert.*;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.builders.ShoppingCartBuilderImpl;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.domain.Customer;
import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.repository.AbstractRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public class ShoppingCartTest {

	@Test
	public void testAdd() {

		AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);

		CustomerRepository customerRepository = abstractRepository.getCustomerRepository();
		ShoppingCartRepository shoppingCartRepository = abstractRepository.getShoppingCartRepository();
		ItemRepository itemRepository = abstractRepository.getItemRepository();

		Customer customer = new Customer();
		customer.setFirstName("Anderson");
		customer.setLastName("Silva");
		customer.setNickName("Anderson Fonseca");

		customerRepository.add(customer);

		Book book = getBook();

		ShoppingCart shoppingCart = new ShoppingCart(customer);
		shoppingCartRepository.add(shoppingCart);

		Item item = new Item(shoppingCart, book, 1);
		itemRepository.add(item);

		ShoppingCart composedShoppingCart = new ShoppingCartBuilderImpl(shoppingCart.getUuid()).build();

		assertNotNull(composedShoppingCart);
		assertTrue(!composedShoppingCart.getItems().isEmpty());

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

		return new BookBuilderImpl(book.getUuid()).build();

	}

}
