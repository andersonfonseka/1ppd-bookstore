package com.oneppd.builders;

import com.oneppd.domain.Customer;

public interface CustomerBuilder extends Builder {

	public Customer builderCustomer(String uuid);
	
	public void buildAddress();
	
	public void buildCreditCard();
	
	public Customer build();
	
}
