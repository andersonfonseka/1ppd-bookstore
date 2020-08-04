package com.oneppd.decorator;

import com.oneppd.domain.Price;

public class PricePrinter implements Printer {

	private Price price;

	public PricePrinter(Price price) {
		super();
		this.price = price;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Price\n");
		sb.append("===================================\n");

		sb.append(this.price.getUuid() + "\n");
		sb.append(this.price.getValue() + "\n");

		return sb.toString();
	}


}
