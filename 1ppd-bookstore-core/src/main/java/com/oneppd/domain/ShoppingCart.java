package com.oneppd.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Entity {
	
	private Customer customer;
	
	private List<Item> items = new ArrayList<Item>();
	
	public ShoppingCart(String uuid) {
		super(uuid);
	}

	public ShoppingCart(Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
