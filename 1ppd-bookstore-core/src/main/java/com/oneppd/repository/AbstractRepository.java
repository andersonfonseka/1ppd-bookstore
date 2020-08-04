package com.oneppd.repository;

import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.ConcreteMemoryRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public abstract class AbstractRepository {
	
	public static final String MEMORY = "MEMORY";
	
	public static AbstractRepository getRepository(String type) {
		
		if (type.equals(AbstractRepository.MEMORY)) {
			return new ConcreteMemoryRepository();
		}
	
		return null;
	}
	
	
	public abstract BookRepository getBookRepository();
	
	public abstract AuthorRepository getAuthorRepository();
	
	public abstract BookHasAuthorRepository getBookHasAuthorRepository();
	
	public abstract CustomerRepository getCustomerRepository();
	
	public abstract ItemRepository getItemRepository();
	
	public abstract ShoppingCartRepository getShoppingCartRepository();
	
	public abstract PriceRepository getPriceRepository();

}
