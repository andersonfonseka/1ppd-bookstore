package com.oneppd.domain;

import java.util.Date;

public class Shipment extends Entity {
	
	private Date date;
	
	private Order order;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
