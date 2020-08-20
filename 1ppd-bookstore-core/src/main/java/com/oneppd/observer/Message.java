package com.oneppd.observer;

public class Message {
	
	public static final String PAYMENT = "PAYMENT";
	public static final String SHIPMENT = "SHIPMENT";
	
	private String type;
	
	private Object message;
	
	public Message(String type, Object message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public Object getMessage() {
		return message;
	}

}
