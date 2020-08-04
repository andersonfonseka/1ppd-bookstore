package com.oneppd.factorymethod;

import java.util.Date;
import java.util.List;

import com.oneppd.domain.Book;
import com.oneppd.domain.Price;
import com.oneppd.repository.AbstractRepository;

public class PricePeriodImpl extends PriceCreator {

	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	private Book book;
	
	public PricePeriodImpl(Book book) {
		super();
		this.book = book;
	}

	@Override
	public Price getPrice() {
		
		List<Price> prices = abstractRepository.getPriceRepository().listByBook(book);
		
		Object price = null;
		
		if (!prices.isEmpty()) {
			
			for (Price p : prices) {
				if (p.getStart().getTime().compareTo(new Date()) < 0 &&
					p.getEnd().getTime().compareTo(new Date()) > 0) {
					price = p;
					break;
				}
			}
			
		}

		return (Price) price;
	}

}
