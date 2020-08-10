package com.oneppd.interpreter;

public class NameExpression implements Expression {

	private String name;
	
	private Expression value;
	
	public NameExpression(String name, Expression value) {
		super();
		this.name = name;
		this.value = value;
	}

	@Override
	public boolean interpreter() {
		return this.name != null;
	}

	@Override
	public Expression getExpression() {
		
		Expression result = null;
		
		if (value.interpreter()) {
			result = this.value;
		}
		
		return result;
	}

	@Override
	public Object getValue() {
		return this.name;
	}

}
