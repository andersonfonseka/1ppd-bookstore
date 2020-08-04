package com.oneppd.repository;

import java.util.List;

import com.oneppd.domain.Entity;

public interface Repository<E> {

	public void add(E entity);
	
	public void update(E entity);
	
	public void remove(E entity);

	public Entity get(E entity);
	
	public List<E> all();

}

