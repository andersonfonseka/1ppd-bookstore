package com.oneppd.service.impl;

import com.oneppd.domain.Address;
import com.oneppd.repository.Repository;
import com.oneppd.service.AddressService;

public class AddressServiceImpl extends ServiceImpl<Address> implements AddressService {

	public AddressServiceImpl(Repository<Address> repository) {
		super(repository);
	}

	

}
