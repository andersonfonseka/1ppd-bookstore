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

	public void setBook(Book book) {
		this.book = book;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Calendar getStart() {
		return start;
	}

	public void setStart(Calendar start) {
		this.start = start;
	}

	public Calendar getEnd() {
		return end;
	}

	public void setEnd(Calendar end) {
		this.end = end;
	}

}
