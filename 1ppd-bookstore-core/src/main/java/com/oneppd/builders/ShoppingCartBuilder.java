package com.oneppd.builders;

import com.oneppd.domain.ShoppingCart;

public interface ShoppingCartBuilder {

	public ShoppingCart builderShoppingCart(String uuid);
	
	public void buildCustomer();
	
	public void buildItems();
	
	public ShoppingCart build();
	
}
