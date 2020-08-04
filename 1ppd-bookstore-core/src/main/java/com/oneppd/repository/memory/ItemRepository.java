package com.oneppd.repository.memory;

import java.util.List;
import java.util.stream.Collectors;

import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;

public class ItemRepository extends BaseRepository<Item> {

	private static ItemRepository INSTANCE;
	
	public static ItemRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ItemRepository();
		}

		return INSTANCE;
	}
	
	
	private ItemRepository() {}
	
	public List<Item> listByShoppingCart(ShoppingCart shoppingCart){
		List<Item> items = super.all().stream()
						.filter(itm -> itm.getShoppingCart().getUuid().equals(shoppingCart.getUuid()))
						.collect(Collectors.toList());
		
		return items;
	}
	
}
