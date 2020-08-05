package com.oneppd.decorator;

import com.oneppd.domain.Item;

public class ItemPrinter implements DecoratorPrinter {

	private Item item;

	public ItemPrinter(Item item) {
		super();
		this.item = item;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Item\n");
		sb.append("===================================\n");


		sb.append(this.item.getUuid() + "\n");
		sb.append(new PrinterImpl(new BookPrinter(this.item.getBook())).doPrint());
		sb.append(this.item.getQuantity() + "\n");

		return sb.toString();
	}

}
