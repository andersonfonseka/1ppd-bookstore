package com.oneppd.state;

import com.oneppd.domain.Order;
import com.oneppd.service.ShipmentService;
import com.oneppd.service.impl.ShipmentServiceImpl;

public class ShipmentState implements State {
	
	private Order order;
	
	public ShipmentState(Order order) {
		super();
		this.order = order;
	}

	@Override
	public void execute() {
		
		ShipmentService shipmentService = new ShipmentServiceImpl();
		shipmentService.process(this.order);

	}

}
