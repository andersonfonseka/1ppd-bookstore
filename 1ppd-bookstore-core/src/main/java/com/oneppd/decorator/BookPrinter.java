package com.oneppd.decorator;

import com.oneppd.domain.Author;
import com.oneppd.domain.Book;

public class BookPrinter implements DecoratorPrinter {

	private Book book;

	public BookPrinter(Book book) {
		super();
		this.book = book;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();

		sb.append("===================================\n");
		sb.append(this.book.getTitle() + ", Edition ");
		sb.append(this.book.getEdition() + "\n");
		
		for (Author author : this.book.getAuthors()) {
			sb.append(new PrinterImpl(new AuthorPrinter(author)).doPrint());
		}

		sb.append(new PrinterImpl(new PricePrinter(this.book.getPrice())).doPrint());

		return sb.toString();
	}

}
