package com.oneppd.repository.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oneppd.domain.Entity;
import com.oneppd.repository.Repository;

public class BaseRepository<E> implements Repository<E> {

	private Map<String, E> database = new HashMap<String, E>();
	
	public void add(E entity) {
		this.database.put(((Entity) entity).getUuid(), entity);
	}

	public void update(E entity) {
		this.database.put(((Entity) entity).getUuid(), entity);
	}

	public void remove(E entity) {
		this.database.remove(((Entity) entity).getUuid(), entity);		
	}

	public Entity get(E entity) {
		return (Entity) this.database.get(((Entity) entity).getUuid());
	}

	public List<E> all() {
		return new ArrayList<E>(this.database.values());
	}

	
	
}
