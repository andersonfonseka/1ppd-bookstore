package com.oneppd.decorator;

import com.oneppd.domain.Item;
import com.oneppd.domain.Order;

public class OrderPrinter implements DecoratorPrinter {

	private Order order;

	public OrderPrinter(Order order) {
		super();
		this.order = order;
	}

	@Override
	public String doPrint() {

		StringBuilder sb = new StringBuilder();
		
		sb.append("Order\n");
		sb.append("===================================\n");


		sb.append(this.order.getUuid() + "\n");
		sb.append(this.order.getDate() + "\n");
		sb.append(new PrinterImpl(new CustomerPrinter(this.order.getCustomer())).doPrint());
		
		for (Item item : this.order.getItems()) {
			sb.append(new PrinterImpl(new ItemPrinter(item)).doPrint());
		}

		return sb.toString();
	}


}
