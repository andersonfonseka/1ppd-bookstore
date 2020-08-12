package com.oneppd.service.impl;

import com.oneppd.domain.Order;
import com.oneppd.observer.Message;
import com.oneppd.observer.Observable;
import com.oneppd.service.ShippingService;

public class ShippingServiceImpl extends ServiceImpl implements ShippingService, Observable {
	
	@Override
	public void process(Order order) {}

	@Override
	public void update(Message o) {
		if (o.getType().equals(Message.SHIPPING)) {
			process((Order) o.getMessage());
		}
	}

}
