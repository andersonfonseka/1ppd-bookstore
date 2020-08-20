package com.oneppd.service;

import com.oneppd.domain.Order;
import com.oneppd.domain.Shipment;

public interface ShipmentService extends Service<Shipment> {

	public void process(Order order);
	
}
