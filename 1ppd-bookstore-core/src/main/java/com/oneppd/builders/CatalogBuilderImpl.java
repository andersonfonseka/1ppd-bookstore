package com.oneppd.builders;

import java.util.ArrayList;
import java.util.List;

import com.oneppd.domain.Book;
import com.oneppd.domain.Catalog;
import com.oneppd.flyweight.BookFlyweight;
import com.oneppd.repository.AbstractRepository;

public class CatalogBuilderImpl implements CatalogBuilder {

	private Catalog catalog;
	
	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	private BookFlyweight catalogFlyweight =  BookFlyweight.getInstance();
	
	public CatalogBuilderImpl(String uuid) {
		this.catalog = builderCatalog(uuid);
		buildBooks();
	}

	@Override
	public Catalog builderCatalog(String uuid) {
		return (Catalog) abstractRepository.getCatalogRepository().get(new Catalog(uuid));
	}

	@Override
	public void buildBooks() {
		
		List<Book> books = new ArrayList<Book>();
		
		for(Book book: this.catalog.getBooks()) {
			books.add(catalogFlyweight.getBook(book));
		}
	}

	@Override
	public Catalog build() {
		return this.catalog;
	}
	
}
