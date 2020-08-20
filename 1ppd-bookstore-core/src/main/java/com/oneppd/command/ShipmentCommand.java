package com.oneppd.command;

import com.oneppd.domain.Order;
import com.oneppd.observer.BookstoreObserver;
import com.oneppd.observer.Message;

public class ShipmentCommand implements Command {
	
	private BookstoreObserver bookstoreObserver = BookstoreObserver.getInstance();

	private Order order;
	
	public ShipmentCommand(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void execute() {
		bookstoreObserver.addMessage(new Message(Message.SHIPMENT, order));
	}

}
