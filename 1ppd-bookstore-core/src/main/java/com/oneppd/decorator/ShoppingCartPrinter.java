package com.oneppd.decorator;

import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;

public class ShoppingCartPrinter implements DecoratorPrinter {

	private ShoppingCart shoppingCart;

	public ShoppingCartPrinter(ShoppingCart shoppingCart) {
		super();
		this.shoppingCart = shoppingCart;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Shopping Cart\n");
		sb.append("===================================\n");
	
		sb.append(new PrinterImpl(new CustomerPrinter(this.shoppingCart.getCustomer())).doPrint());
		
		for (Item item : this.shoppingCart.getItems()) {
			sb.append(new PrinterImpl(new ItemPrinter(item)).doPrint());
		}

		return sb.toString();
	}


}
