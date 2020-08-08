package com.oneppd.service;

import com.oneppd.domain.Order;

public interface ShippingService extends Service {

	public void process(Order order);
	
}
