package com.oneppd.builders;

import com.oneppd.domain.Order;

public interface OrderBuilder extends Builder {

	public Order builderOrder(String uuid);
	
	public void buildCustomer();
	
	public void buildItems();
	
	public Order build();
	
}
