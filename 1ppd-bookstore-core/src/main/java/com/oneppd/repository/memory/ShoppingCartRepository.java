package com.oneppd.repository.memory;

import com.oneppd.domain.ShoppingCart;

public class ShoppingCartRepository extends BaseRepository<ShoppingCart> {

	private static ShoppingCartRepository INSTANCE;
	
	public static ShoppingCartRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ShoppingCartRepository();
		}

		return INSTANCE;
	}
	
	
	private ShoppingCartRepository() {}
	
}
