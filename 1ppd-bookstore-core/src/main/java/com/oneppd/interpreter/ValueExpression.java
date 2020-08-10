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
	
	@Override
	public Expression getExpression() {
		return this;
	}

	@Override
	public Object getValue() {
		return this.value;
	}
	
	

}
