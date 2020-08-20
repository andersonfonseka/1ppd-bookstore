package com.oneppd.state;

import com.oneppd.command.ShipmentCommand;
import com.oneppd.domain.Order;

public class NotificationState implements State {

	private Order order;
	
	public NotificationState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void execute() {
		System.out.println("Notification service... calling shipment service");
		new ShipmentCommand(this.order).execute();		
	}

}
