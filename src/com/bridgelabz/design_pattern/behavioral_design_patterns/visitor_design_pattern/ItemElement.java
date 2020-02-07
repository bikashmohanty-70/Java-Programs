package com.bridgelabz.design_pattern.behavioral_design_patterns.visitor_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: itemElement Interface
 *
 */

public interface ItemElement 
{
	public int accept(ShoppingCartVisitor visitor);
}
