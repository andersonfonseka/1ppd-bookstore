package com.oneppd.builders;

import java.util.List;

import com.oneppd.domain.Customer;
import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.repository.AbstractRepository;

public class ShoppingCartBuilderImpl implements ShoppingCartBuilder {

	private ShoppingCart shoppingCart;

	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	public ShoppingCartBuilderImpl(String uuid) {
		this.shoppingCart = builderShoppingCart(uuid);
		buildCustomer();
		buildItems();
	}

	@Override
	public ShoppingCart builderShoppingCart(String uuid) {
		return (ShoppingCart) abstractRepository.getShoppingCartRepository().get(new ShoppingCart(uuid));
	}

	@Override
	public void buildCustomer() {
		this.shoppingCart.setCustomer((Customer) abstractRepository.getCustomerRepository().get(this.shoppingCart.getCustomer()));
	}

	@Override
	public void buildItems() {
		
		List<Item> items = abstractRepository.getItemRepository().listByShoppingCart(this.shoppingCart);
		
		for (Item item : items) {
			item = new ItemBuilderImpl(item.getUuid()).build();
		}
		
		this.shoppingCart.setItems(items);
	}

	@Override
	public ShoppingCart build() {
		return this.shoppingCart;
	}

	
}
