package com.oneppd.domain;

public class Customer extends Person {

	private String firstName;

	private String lastName;

	private String nickName;
	
	public Customer() {
		super();
	}

	public Customer(String uuid) {
		super(uuid);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		
		if (null == nickName)
			return this.firstName + " " + this.lastName;
		
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
