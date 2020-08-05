package com.oneppd.repository;

import com.oneppd.bridge.ConcreteRepositoryBridge;
import com.oneppd.repository.memory.AuthorRepository;
import com.oneppd.repository.memory.BookHasAuthorRepository;
import com.oneppd.repository.memory.BookRepository;
import com.oneppd.repository.memory.CatalogRepository;
import com.oneppd.repository.memory.ConcreteMemoryRepository;
import com.oneppd.repository.memory.CustomerRepository;
import com.oneppd.repository.memory.ItemRepository;
import com.oneppd.repository.memory.PriceRepository;
import com.oneppd.repository.memory.ShoppingCartRepository;

public abstract class BookstoreAbstractRepository extends AbstractRepository {
	
	public static final String MEMORY = "MEMORY";
	
	public static BookstoreAbstractRepository getRepository(String type) {
		
		if (type.equals(BookstoreAbstractRepository.MEMORY)) {
			return new ConcreteRepositoryBridge(new ConcreteMemoryRepository());
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
	
	public abstract CatalogRepository getCatalogRepository();

}
