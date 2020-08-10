package com.oneppd.interpreter;

public interface Expression {
	
	public Object getValue();
	
	public Expression getExpression();

	boolean interpreter(); 
	
}
