package com.oneppd.bridge;

import com.oneppd.repository.BookstoreAbstractRepository;
import com.oneppd.repository.BookstoreConcreteRepository;
import com.oneppd.repository.memory.AddressRepository;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CatalogRepository;
import com.oneppd.repository.memory.CreditCardRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public class ConcreteRepositoryBridge extends BookstoreAbstractRepository implements Bridge {
	
	private BookstoreConcreteRepository concreteRepository;
	
	public ConcreteRepositoryBridge(BookstoreConcreteRepository concreteRepository) {
		super();
		this.concreteRepository = concreteRepository;
	}

	@Override
	public BookRepository getBookRepository() {
		return concreteRepository.getBookRepository();
	}

	@Override
	public AuthorRepository getAuthorRepository() {
		return concreteRepository.getAuthorRepository();
	}

	@Override
	public BookHasAuthorRepository getBookHasAuthorRepository() {
		return concreteRepository.getBookHasAuthorRepository();
	}

	@Override
	public CustomerRepository getCustomerRepository() {
		return concreteRepository.getCustomerRepository();
	}

	@Override
	public ItemRepository getItemRepository() {
		return concreteRepository.getItemRepository();
	}

	@Override
	public ShoppingCartRepository getShoppingCartRepository() {
		return concreteRepository.getShoppingCartRepository();
	}

	@Override
	public PriceRepository getPriceRepository() {
		return concreteRepository.getPriceRepository();
	}

	@Override
	public CatalogRepository getCatalogRepository() {
		return concreteRepository.getCatalogRepository();
	}

	@Override
	public AddressRepository getAddressRepository() {
		return concreteRepository.getAddressRepository();
	}

	@Override
	public CreditCardRepository getCreditCardRepository() {
		return concreteRepository.getCreditCardRepository();
	}

}
