package com.oneppd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Entity {
	
	private Date date;
	
	private Customer customer;
	
	private List<Item> items = new ArrayList<Item>(10);
	
	private Payment payment;
	
	private Address shippingAddress;
	
	public Order() {
		super();
	}

	public Order(String uuid) {
		super(uuid);
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
