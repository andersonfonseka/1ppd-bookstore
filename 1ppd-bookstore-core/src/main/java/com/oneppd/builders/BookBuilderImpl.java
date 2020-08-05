package com.oneppd.builders;

import com.oneppd.domain.Book;
import com.oneppd.factorymethod.PriceCreator;
import com.oneppd.factorymethod.PricePeriodImpl;
import com.oneppd.repository.BookstoreAbstractRepository;

public class BookBuilderImpl implements BookBuilder {

	private Book book;

	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	public BookBuilderImpl(String uuid) {
		this.book = builderBook(uuid);
		buildAuthors();
		buildPrice();
	}

	public Book builderBook(String uuid) {
		return (Book) abstractRepository.getBookRepository().get(new Book(uuid));
	}

	public void buildAuthors() {
		this.book.setAuthors(abstractRepository.getBookHasAuthorRepository().listByBook(this.book));
	}

	public Book build() {
		return book;
	}
	
	@Override
	public void buildPrice() {
		PriceCreator priceCreator = new PricePeriodImpl(this.book);
		this.book.setPrice(priceCreator.getPrice());
	}
	
	
}
