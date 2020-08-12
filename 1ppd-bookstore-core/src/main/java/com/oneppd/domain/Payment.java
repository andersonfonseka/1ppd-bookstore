package com.oneppd.domain;

import java.util.Date;

public class Payment extends Entity {
	
	public static final String VISA = "VISA";
	public static final String MASTERCARD = "MASTERCARD";
	public static final String AMEX = "AMEX";
	public static final String PAYPAL = "PAYPAL";
	
	private Date date;
	
	private PaymentMethod paymentMethod;
	
	private Double value;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
