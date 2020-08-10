package com.oneppd.factorymethod;

import java.util.GregorianCalendar;
import java.util.List;

import com.oneppd.domain.Book;
import com.oneppd.domain.Price;
import com.oneppd.interpreter.AndExpression;
import com.oneppd.interpreter.DateGreaterThanExpression;
import com.oneppd.interpreter.DateLessThanExpression;
import com.oneppd.interpreter.NameExpression;
import com.oneppd.interpreter.ValueExpression;
import com.oneppd.repository.BookstoreAbstractRepository;

public class PricePeriodImpl extends PriceCreator {

	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	private Book book;
	
	public PricePeriodImpl(Book book) {
		super();
		this.book = book;
	}

	@Override
	public Price getPrice() {
		
		List<Price> prices = abstractRepository.getPriceRepository().listByBook(book);
		
		Price price = null;
		
		if (!prices.isEmpty()) {
			price = (Price) prices.stream()
							.filter(p -> validatePricePeriod(p).interpreter())
							.findFirst().get();
		}

		return (Price) price;
	}

	private AndExpression validatePricePeriod(Price p) {
		
		NameExpression dataInicial = new NameExpression("dataInicialPreco", new ValueExpression(p.getStart()));
		NameExpression dataFinal = new NameExpression("dataFinalPreco", new ValueExpression(p.getEnd()));
		
		NameExpression dataAtual = new NameExpression("dataAtual", new ValueExpression(new GregorianCalendar()));
		
		DateLessThanExpression dateLessThanExpression = new DateLessThanExpression(dataInicial, dataAtual);
		DateGreaterThanExpression dateGreaterThanExpression = new DateGreaterThanExpression(dataFinal, dataAtual);

		AndExpression andExpression = new AndExpression(dateLessThanExpression, dateGreaterThanExpression);
		return andExpression;
	}

}
