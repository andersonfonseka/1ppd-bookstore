package com.oneppd.state;

import com.oneppd.domain.Order;
import com.oneppd.observer.Message;
import com.oneppd.observer.Observable;

public class Context implements Observable {
	
	private State state = null;

	public Context() {
		super();
	}
	
	public void execute() {
		this.state.execute();
	}

	@Override
	public void update(Message o) {
		if (o.getType().equals(Message.PAYMENT)) {
			this.state = new PaymentState((Order) o.getMessage());
			execute();
		} else if (o.getType().equals(Message.SHIPMENT)) {
			this.state = new ShipmentState((Order) o.getMessage());
			execute();
		}
	}

}
