package com.oneppd.repository.memory;

import com.oneppd.domain.Order;

public class OrderRepository extends BaseRepository<Order> {
	
	private static OrderRepository INSTANCE;
	
	public static OrderRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new OrderRepository();
		}

		return INSTANCE;
	}
	
	private OrderRepository() {}
	
//	public List<Order> listByPerson(Person person){
//		List<Order> orders = super.all().stream()
//						.filter(ps -> ps.getCustomer().getUuid().equals(person.getUuid()))
//						.collect(Collectors.toList());
//		
//		return orders;
//	}
	

}
