package com.oneppd.builders;

import com.oneppd.domain.Order;
import com.oneppd.repository.BookstoreAbstractRepository;

public class OrderBuilderImpl implements OrderBuilder {
	
	private Order order;
	
	private BookstoreAbstractRepository abstractRepository = BookstoreAbstractRepository.getRepository(BookstoreAbstractRepository.MEMORY);
	
	public OrderBuilderImpl(String uuid) {
		this.order = builderOrder(uuid);
		buildCustomer();
		buildItems();
	}

	@Override
	public Order builderOrder(String uuid) {
		return abstractRepository.getOrderRepository().get(new Order(uuid));
	}

	@Override
	public void buildCustomer() {
		this.order.setCustomer(abstractRepository.getCustomerRepository().get(this.order.getCustomer()));
		
	}

	@Override
	public void buildItems() {
		this.order.setItems(abstractRepository.getItemRepository().listByOrder(this.order));
	}

	@Override
	public Order build() {
		return this.order;
	}

}
