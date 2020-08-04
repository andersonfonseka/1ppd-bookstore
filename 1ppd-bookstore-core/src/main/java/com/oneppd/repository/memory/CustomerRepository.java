package com.oneppd.repository.memory;

import com.oneppd.domain.Customer;

public class CustomerRepository extends BaseRepository<Customer> {
	
	private static CustomerRepository INSTANCE;
	
	public static CustomerRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CustomerRepository();
		}

		return INSTANCE;
	}
	
	private CustomerRepository() {}
	

}
