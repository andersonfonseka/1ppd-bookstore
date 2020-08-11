package com.oneppd.test;

import static org.junit.Assert.assertNotNull;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import com.oneppd.builders.BookBuilderImpl;
import com.oneppd.builders.CustomerBuilder;
import com.oneppd.builders.CustomerBuilderImpl;
import com.oneppd.builders.OrderBuilderImpl;
import com.oneppd.builders.ShoppingCartBuilderImpl;
import com.oneppd.decorator.CustomerPrinter;
import com.oneppd.decorator.DecoratorPrinter;
import com.oneppd.decorator.PrinterImpl;
import com.oneppd.decorator.ShoppingCartPrinter;
import com.oneppd.domain.Address;
import com.oneppd.domain.Author;
import com.oneppd.domain.Book;
import com.oneppd.domain.BookHasAuthor;
import com.oneppd.domain.CreditCard;
import com.oneppd.domain.Customer;
import com.oneppd.domain.Item;
import com.oneppd.domain.Order;
import com.oneppd.domain.Payment;
import com.oneppd.domain.PaymentMethod;
import com.oneppd.domain.Price;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.mediator.OrderMediator;
import com.oneppd.mediator.OrderMediatorImpl;
import com.oneppd.observer.BookstoreObserver;
import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.memory.AddressRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CreditCardRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public class OrderTest {

	@Before
	public void setUp() {
		BookstoreObserver.getInstance();
	}

	@Test
	public void testExpiration() {
		
		ShoppingCart shoppingCart = getShoppingCart();
		OrderMediator orderMediator = new OrderMediatorImpl(shoppingCart);
		
		Customer customer = shoppingCart.getCustomer();
		PaymentMethod paymentMethod = customer.getCreditCards().get(0);
		Address shippingAddress = customer.getAddresses().get(0);
		
		
		Item item = new Item(shoppingCart, getBook3(), 1);
		
		orderMediator.remove(shoppingCart.getItems().get(0));
		
		orderMediator.add(item);
		
		item.setQuantity(2);
		
		orderMediator.update(item);
		
		orderMediator.checkout(paymentMethod, shippingAddress);
		
		orderMediator.complete();
		
		Order orderCompleted = new OrderBuilderImpl(orderMediator.getOrder().getUuid()).build();
		
		System.out.println(orderMediator.print());
		
		assertNotNull(orderCompleted);

	}
	
	@Test
	public void testValid() {

		
		ShoppingCart shoppingCart = getShoppingCart();
		OrderMediator orderMediator = new OrderMediatorImpl(shoppingCart);
		
		Customer customer = shoppingCart.getCustomer();
		PaymentMethod paymentMethod = customer.getCreditCards().get(1);
		Address shippingAddress = customer.getAddresses().get(0);
		
		
		Item item = new Item(shoppingCart, getBook3(), 1);
		
		orderMediator.remove(shoppingCart.getItems().get(0));
		
		orderMediator.add(item);
		
		item.setQuantity(2);
		
		orderMediator.update(item);
		
		orderMediator.checkout(paymentMethod, shippingAddress);

	}
	
	@Test
	public void testNoLimit() {

		
		ShoppingCart shoppingCart = getShoppingCart();
		OrderMediator orderMediator = new OrderMediatorImpl(shoppingCart);
		
		Customer customer = shoppingCart.getCustomer();
		PaymentMethod paymentMethod = customer.getCreditCards().get(2);
		Address shippingAddress = customer.getAddresses().get(0);
		
		
		Item item = new Item(shoppingCart, getBook3(), 1);
		
		orderMediator.remove(shoppingCart.getItems().get(0));
		
		orderMediator.add(item);
		
		item.setQuantity(2);
		
		orderMediator.update(item);
		
		orderMediator.checkout(paymentMethod, shippingAddress);

	}

	


	
	private ShoppingCart getShoppingCart() {
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);

		ShoppingCartRepository shoppingCartRepository = abstractRepository.getShoppingCartRepository();
		ItemRepository itemRepository = abstractRepository.getItemRepository();

		Customer customer = getCustomer();

		ShoppingCart shoppingCart = new ShoppingCart(customer);
		shoppingCartRepository.add(shoppingCart);

		Book bookTest =  getBook();
		
		itemRepository.add(new Item(shoppingCart, bookTest, 1));
		itemRepository.add(new Item(shoppingCart, getBook2(), 1));
		itemRepository.add(new Item(shoppingCart, bookTest, 1));

		ShoppingCart composedShoppingCart = new ShoppingCartBuilderImpl(shoppingCart.getUuid()).build();

		DecoratorPrinter printer = new PrinterImpl(new ShoppingCartPrinter(composedShoppingCart));
		System.out.println(printer.doPrint());
		
		return composedShoppingCart;
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
	
	private Book getBook3() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		BookRepository bookRepository = abstractRepository.getBookRepository();
		AuthorRepository authorRepository = abstractRepository.getAuthorRepository();
		BookHasAuthorRepository bookHasAuthorRepository = abstractRepository.getBookHasAuthorRepository();
		
		Book book = new Book();
		book.setTitle("Building Evolutionary Architectures: Support Constant Change");
		book.setEdition(1);
		
		bookRepository.add(book);
		
		Author author1 = new Author();
		author1.setName("Neal Ford");
		
		authorRepository.add(author1);
		
		bookHasAuthorRepository.add(new BookHasAuthor(book, author1));
		
		PriceRepository priceRepository = abstractRepository.getPriceRepository();

		Price price0 = new Price(book, 37.68, new GregorianCalendar(2020, 6, 1), new GregorianCalendar(2020, 6, 30));
		Price price1 = new Price(book, 49.50, new GregorianCalendar(2020, 7, 1), new GregorianCalendar(2020, 7, 30));
		Price price2 = new Price(book, 60.00, new GregorianCalendar(2020, 8, 1), new GregorianCalendar(2020, 8, 30));

		priceRepository.add(price0);
		priceRepository.add(price1);
		priceRepository.add(price2);
		
		return new BookBuilderImpl(book.getUuid()).build();
		
	}
	
	private Customer getCustomer() {
		
		BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
		
		CustomerRepository customerRepository = abstractRepository.getCustomerRepository();
		AddressRepository addressRepository = abstractRepository.getAddressRepository();
		CreditCardRepository creditCardRepository = abstractRepository.getCreditCardRepository();
		
		Customer customer = new Customer();
		customer.setFirstName("Anderson");
		customer.setLastName("Fonseca");
		
		customerRepository.add(customer);
		
		Address address = new Address();
		address.setPerson(customer);
		address.setAddress("Av. Tucunare, 2000");
		address.setAddress2("Condominio XPTO");
		address.setCity("Barueri");
		address.setState("SP");
		address.setCountry("Brazil");
		address.setZip("06000-000");
		
		addressRepository.add(address);
		
		CreditCard creditCard = new CreditCard();
		creditCard.setPerson(customer);
		creditCard.setType(Payment.VISA);
		creditCard.setFirstName(customer.getFirstName());
		creditCard.setLastName(customer.getLastName());
		creditCard.setExpirationMonth(2);
		creditCard.setExpirationYear(2019);
		creditCard.setNumber("0800 8910 3680 0500");
		creditCard.setLimit(100.00);
		creditCard.setSecurityCode("123");
		
		CreditCard creditCard1 = new CreditCard();
		creditCard1.setPerson(customer);
		creditCard1.setType(Payment.MASTERCARD);
		creditCard1.setFirstName(customer.getFirstName());
		creditCard1.setLastName(customer.getLastName());
		creditCard1.setExpirationMonth(12);
		creditCard1.setExpirationYear(2021);
		creditCard1.setNumber("5105 1051 0510 5100");
		creditCard1.setLimit(200.00);
		creditCard1.setSecurityCode("666");
		
		CreditCard creditCard2 = new CreditCard();
		creditCard2.setPerson(customer);
		creditCard2.setType(Payment.AMEX);
		creditCard2.setFirstName(customer.getFirstName());
		creditCard2.setLastName(customer.getLastName());
		creditCard2.setExpirationMonth(12);
		creditCard2.setExpirationYear(2021);
		creditCard2.setNumber("3782 8224 6310 005");
		creditCard2.setLimit(50.00);
		creditCard2.setSecurityCode("999");
		
		creditCardRepository.add(creditCard);
		creditCardRepository.add(creditCard1);
		creditCardRepository.add(creditCard2);
		
		CustomerBuilder builder = new CustomerBuilderImpl(customer.getUuid());
		Customer customer2 = builder.build();
		
		DecoratorPrinter printer = new PrinterImpl(new CustomerPrinter(customer2));
		System.out.println(printer.doPrint());
		
		return customer2;
		
	}

}
