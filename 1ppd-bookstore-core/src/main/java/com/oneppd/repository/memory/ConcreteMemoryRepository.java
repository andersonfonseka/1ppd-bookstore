package com.oneppd.repository.memory;

import com.oneppd.repository.AbstractRepository;

public class ConcreteMemoryRepository extends AbstractRepository {

	@Override
	public BookRepository getBookRepository() {
		return BookRepository.getInstance();
	}

	@Override
	public AuthorRepository getAuthorRepository() {
		return AuthorRepository.getInstance();
	}

	@Override
	public BookHasAuthorRepository getBookHasAuthorRepository() {
		return BookHasAuthorRepository.getInstance();
	}

	@Override
	public CustomerRepository getCustomerRepository() {
		return CustomerRepository.getInstance();
	}

	@Override
	public ItemRepository getItemRepository() {
		return ItemRepository.getInstance();
	}

	@Override
	public ShoppingCartRepository getShoppingCartRepository() {
		return ShoppingCartRepository.getInstance();
	}

	@Override
	public PriceRepository getPriceRepository() {
		return PriceRepository.getInstance();
	}

}
