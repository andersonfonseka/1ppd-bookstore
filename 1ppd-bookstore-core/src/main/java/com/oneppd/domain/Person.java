package com.oneppd.domain;

import java.util.ArrayList;
import java.util.List;

public class Person extends Entity {
	
	private List<CreditCard> creditCards = new ArrayList<CreditCard>();
	
	private List<Address> addresses = new ArrayList<Address>();
	
	public Person() {
		super();
	}

	public Person(String uuid) {
		super(uuid);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
}
