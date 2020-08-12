package com.oneppd.service;

import java.util.List;

public interface Service<E> {

	public void add(E entity);

	public void update(E entity);

	public void remove(E entity);

	public E get(E entity);

	public List<E> all();
	
}
