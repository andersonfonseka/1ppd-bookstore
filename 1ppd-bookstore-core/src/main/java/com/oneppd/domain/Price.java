package com.oneppd.domain;

import java.util.Calendar;

public class Price extends Entity {

	private Book book;

	private Double value;

	private Calendar start;

	private Calendar end;
	
	public Price(Book book, Double value, Calendar start, Calendar end) {
		super();
		this.book = book;
		this.value = value;
		this.start = start;
		this.end = end;
	}

	public Book getBook() {
		return book;
	}
	
	public Double getValue() {
		return value;
	}

	public Calendar getStart() {
		return start;
	}

	public Calendar getEnd() {
		return end;
	}

}
