package com.oneppd.decorator;

import com.oneppd.domain.Book;
import com.oneppd.domain.Catalog;

public class CatalogPrinter implements DecoratorPrinter {
	
	private Catalog catalog;

	public CatalogPrinter(Catalog catalog) {
		super();
		this.catalog = catalog;
	}

	@Override
	public String doPrint() {
		
		StringBuilder sb = new StringBuilder();

		sb.append("Catalog\n");
		sb.append("===================================\n");

		
		sb.append(this.catalog.getUuid() + "\n");
		sb.append(this.catalog.getName() + "\n");
		
		for (Book book : this.catalog.getBooks()) {
			sb.append(new PrinterImpl(new BookPrinter(book)).doPrint());
		}
		
		return sb.toString();
	}
	

}
