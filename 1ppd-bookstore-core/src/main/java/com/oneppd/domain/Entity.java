package com.oneppd.domain;

import java.util.UUID;

public class Entity {
	
	private String uuid = UUID.randomUUID().toString();

	public Entity() {
		super();
	}
	
	public Entity(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return uuid;
	}
	
}
