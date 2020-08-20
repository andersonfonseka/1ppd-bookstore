package com.oneppd.memento;

import java.util.Stack;

import com.oneppd.domain.ShoppingCart;

public class Memento {
	
	private static Memento INSTANCE = new Memento();

	private Stack<ShoppingCart> list = new Stack<ShoppingCart>();
	
	private Memento() {}
	
	public static Memento getInstance() {
		
		if (INSTANCE == null) {
			INSTANCE = new Memento();
		}

		return INSTANCE;
	}
	
	
	public void saveState(ShoppingCart e) {
		try {
			this.list.push(e.clone());
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
	}
	
	public ShoppingCart restore() {
		return list.pop();
	}

}
