package com.oneppd.repository.memory;

import com.oneppd.repository.ConcreteRepository;

public class ConcreteMemoryRepository extends ConcreteRepository {

	public BookRepository getBookRepository() {
		return BookRepository.getInstance();
	}

	public AuthorRepository getAuthorRepository() {
		return AuthorRepository.getInstance();
	}

	public BookHasAuthorRepository getBookHasAuthorRepository() {
		return BookHasAuthorRepository.getInstance();
	}

	public CustomerRepository getCustomerRepository() {
		return CustomerRepository.getInstance();
	}

	public ItemRepository getItemRepository() {
		return ItemRepository.getInstance();
	}

	public ShoppingCartRepository getShoppingCartRepository() {
		return ShoppingCartRepository.getInstance();
	}

	public PriceRepository getPriceRepository() {
		return PriceRepository.getInstance();
	}

	@Override
	public CatalogRepository getCatalogRepository() {
		return CatalogRepository.getInstance();
	}

}
