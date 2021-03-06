package com.oneppd.domain;

public class Item extends Entity {
	
	private ShoppingCart shoppingCart;
	
	private Order order;
	
	private Book book;
	
	private Integer quantity;
		
	public Item(String uuid) {
		super(uuid);
	}

	public Item(ShoppingCart shoppingCart, Book book, Integer quantity) {
		super();
		this.shoppingCart = shoppingCart;
		this.book = book;
		this.quantity = quantity;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
