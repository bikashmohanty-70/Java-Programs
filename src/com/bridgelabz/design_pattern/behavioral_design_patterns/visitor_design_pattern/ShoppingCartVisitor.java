package com.bridgelabz.design_pattern.behavioral_design_patterns.visitor_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: ShoppingCartVisitor interface
 *
 */
public interface ShoppingCartVisitor 
{
	int visit(Book book);
	int visit(Fruit fruit);
}
