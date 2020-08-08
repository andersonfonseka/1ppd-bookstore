package com.oneppd.decorator;

import com.oneppd.domain.Address;

public class AddressPrinter implements DecoratorPrinter {

	private Address address;

	public AddressPrinter(Address address) {
		super();
		this.address = address;
	}

	@Override
	public String doPrint() {
		
			StringBuilder sb = new StringBuilder();
			
			sb.append("Customer\n");
			sb.append("===================================\n");

			sb.append(address.getAddress()+"\n");
			sb.append(address.getAddress2()+"\n");
			sb.append(address.getCity()+"\n");
			sb.append(address.getState()+"\n");
			sb.append(address.getCountry()+"\n");
			sb.append(address.getZip()+"\n");
			
			return sb.toString();
	}

	
}
