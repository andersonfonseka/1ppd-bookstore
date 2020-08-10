package com.oneppd.interpreter;

public class ValueExpression implements Expression {
	
	private Object value;
	
	public ValueExpression(Object value) {
		super();
		this.value = value;
	}

	@Override
	public boolean interpreter() {
		return value != null;
	}

	public Object getValue() {
		return this.value;
	}

	@Override
	public Expression getExpression() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
