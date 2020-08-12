package com.oneppd.service.impl;

import com.oneppd.domain.Customer;
import com.oneppd.repository.Repository;
import com.oneppd.service.CustomerService;

public class CustomerServiceImpl extends ServiceImpl<Customer> implements CustomerService {

	public CustomerServiceImpl(Repository<Customer> repository) {
		super(repository);
	}

	

}
