package com.oneppd.command;

import com.oneppd.domain.Order;

public class OrderCommand implements Command {
	
	private Order order;
	
	public OrderCommand(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void execute() {
		new PaymentCommand(this.order).execute();
		new ShippingCommand(this.order).execute();
	}

}
