package com.oneppd.decorator;

import com.oneppd.domain.Customer;

public class CustomerPrinter implements Printer {

	private Customer customer;

	public CustomerPrinter(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public String doPrint() {
		
			StringBuilder sb = new StringBuilder();
			
			sb.append("Customer\n");
			sb.append("===================================\n");

			
			sb.append(this.customer.getUuid() +"\n");
			sb.append(this.customer.getFirstName() +"\n");
			sb.append(this.customer.getLastName() +"\n");
			sb.append(this.customer.getNickName() +"\n");
		
			return sb.toString();
	}

	
}
