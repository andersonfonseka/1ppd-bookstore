package com.oneppd.repository.memory;

import java.util.List;
import java.util.stream.Collectors;

import com.oneppd.domain.Book;
import com.oneppd.domain.Price;

public class PriceRepository extends BaseRepository<Price> {

	private static PriceRepository INSTANCE;
	
	public static PriceRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PriceRepository();
		}

		return INSTANCE;
	}
	
	
	private PriceRepository() {}
	
	public List<Price> listByBook(Book book){
		List<Price> prices = super.all().stream()
						.filter(b -> b.getBook().getUuid().equals(book.getUuid()))
						.collect(Collectors.toList());
		
		return prices;
	}
	
}
