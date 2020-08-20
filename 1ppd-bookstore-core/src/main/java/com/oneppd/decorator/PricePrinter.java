package com.oneppd.decorator;

import com.oneppd.domain.Price;

public class PricePrinter implements DecoratorPrinter {

	private Price price;

	public PricePrinter(Price price) {
		super();
		this.price = price;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("\n$ " + this.price.getValue() + "\n");

		return sb.toString();
	}


}
