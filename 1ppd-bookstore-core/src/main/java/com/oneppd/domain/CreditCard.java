package com.oneppd.domain;

public class CreditCard extends Entity implements PaymentMethod {
	
	private Person person;
	
	private String type;

	private String firstName;

	private String lastName;

	private String number;

	private String securityCode;

	private Integer expirationMonth;

	private Integer expirationYear;
	
	private double limit;
	
	public CreditCard() {
		super();
	}

	public CreditCard(String uuid) {
		super(uuid);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Integer getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(Integer expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public Integer getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(Integer expirationYear) {
		this.expirationYear = expirationYear;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

}
