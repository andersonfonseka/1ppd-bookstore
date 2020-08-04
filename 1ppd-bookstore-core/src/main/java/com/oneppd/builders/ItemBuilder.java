package com.oneppd.builders;

import com.oneppd.domain.Item;

public interface ItemBuilder {

	public Item builderItem(String uuid);
	
	public void buildShoppingCart();

	public void buildBook();
	
	public Item build();
	
}
