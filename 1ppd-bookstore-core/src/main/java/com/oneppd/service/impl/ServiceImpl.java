package com.oneppd.service.impl;

import java.util.List;

import com.oneppd.domain.Entity;
import com.oneppd.repository.Repository;
import com.oneppd.service.Service;

public class ServiceImpl<E extends Entity> implements Service<E> {
	
	private Repository<E> repository;

	public ServiceImpl() {}
	
	public ServiceImpl(Repository<E> repository) {
		super();
		this.repository = repository;
	}

	public Repository<E> getRepository() {
		return repository;
	}

	@Override
	public void add(E entity) {
		this.repository.add(entity);
	}

	@Override
	public void update(E entity) {
		this.repository.update(entity);
	}

	@Override
	public void remove(E entity) {
		this.repository.remove(entity);
	}

	@Override
	public E get(E entity) {
		return this.repository.get(entity);
	}

	@Override
	public List<E> all() {
		return this.repository.all();
	}
	
	
	
}
