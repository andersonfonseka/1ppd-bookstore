package com.oneppd.builders;

import com.oneppd.domain.Book;
import com.oneppd.domain.Item;
import com.oneppd.domain.ShoppingCart;
import com.oneppd.factorymethod.PriceCreator;
import com.oneppd.factorymethod.PricePeriodImpl;
import com.oneppd.repository.AbstractRepository;

public class ItemBuilderImpl implements ItemBuilder {

	private Item item;

	private AbstractRepository abstractRepository = AbstractRepository.getRepository(AbstractRepository.MEMORY);
	
	public ItemBuilderImpl(String uuid) {
		this.item = builderItem(uuid);
		buildShoppingCart();
		buildBook();
		buildPrice();
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
		this.item.setBook((Book) abstractRepository.getBookRepository().get(this.item.getBook()));
	}

	@Override
	public Item build() {
		return this.item;
	}

	@Override
	public void buildPrice() {
		PriceCreator priceCreator = new PricePeriodImpl(this.item.getBook());
		this.item.setPrice(priceCreator.getPrice());
	}
	
}
