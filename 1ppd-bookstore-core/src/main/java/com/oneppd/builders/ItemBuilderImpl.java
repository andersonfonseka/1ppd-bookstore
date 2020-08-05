package com.oneppd.builders;

import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.flyweight.BookFlyweight;
import com.oneppd.repository.AbstractRepository;

public class ItemBuilderImpl implements ItemBuilder {

	private Item item;

	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	private BookFlyweight catalogFlyweight =  BookFlyweight.getInstance();
	
	public ItemBuilderImpl(String uuid) {
		this.item = builderItem(uuid);
		buildShoppingCart();
		buildBook();
	}

	@Override
	public Item builderItem(String uuid) {
		return (Item) abstractRepository.getItemRepository().get(new Item(uuid));
	}

	@Override
	public void buildShoppingCart() {
		this.item.setShoppingCart((ShoppingCart) abstractRepository.getShoppingCartRepository().get(this.item.getShoppingCart()));
	}

	@Override
	public void buildBook() {

		this.item.setBook(catalogFlyweight.getBook(this.item.getBook()));
	}

	@Override
	public Item build() {
		return this.item;
	}
	
}
