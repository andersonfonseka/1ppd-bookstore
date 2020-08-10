package com.oneppd.mediator;

import com.oneppd.domain.Address;
import com.oneppd.domain.Item;
import com.oneppd.domain.Order;
import com.oneppd.domain.PaymentMethod;

public interface OrderMediator {
	
	public Order getOrder();
	
	public void checkout(PaymentMethod paymentMethod, Address shippingAddress);
	
	public void remove(Item item);
	
	public void update(Item item);
	
	public void add(Item item);
	
	public void complete();
	
	public String print();
}
