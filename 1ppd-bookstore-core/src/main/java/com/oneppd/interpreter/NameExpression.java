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
		return this.value.interpreter();
	}

	public Object getValue() {
		return name;
	}

	public Expression getExpression() {
		return this.value;
	}

}
