package com.oneppd.service.impl;

import com.oneppd.domain.Order;
import com.oneppd.observer.BookstoreObserver;
import com.oneppd.observer.Message;
import com.oneppd.observer.Observable;
import com.oneppd.service.ShippingService;

public class ShippingServiceImpl implements ShippingService, Observable {

	private BookstoreObserver bookstoreObserver = BookstoreObserver.getInstance();
	
	public ShippingServiceImpl() {
		bookstoreObserver.add(this);
	}
	
	@Override
	public void process(Order order) {}

	@Override
	public void update(Message o) {
		if (o.getType().equals(Message.SHIPPING)) {
			process((Order) o.getMessage());
		}
	}

}
