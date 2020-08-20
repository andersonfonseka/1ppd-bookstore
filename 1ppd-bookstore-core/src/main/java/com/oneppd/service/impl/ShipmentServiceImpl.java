package com.oneppd.service.impl;

import com.oneppd.domain.Order;
import com.oneppd.domain.Shipment;
import com.oneppd.service.ShipmentService;

public class ShipmentServiceImpl extends ServiceImpl<Shipment> implements ShipmentService {
	
	@Override
	public void process(Order order) {
		System.out.println("Delivering order no. " + order.getUuid());
	}


}
