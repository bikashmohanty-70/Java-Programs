package com.bridgelabz.design_pattern.behavioral_design_patterns.visitor_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: ShoppingCartVisitor implementations
 *
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor 
{

	@Override
	public int visit(Book book) 
	{
		int cost=0;
		
		if(book.getPrice() > 50){
			cost = book.getPrice()-5;	// Rs/-5 discount if book price is greater than 50
		}else cost = book.getPrice();
		System.out.println("Book Name: "+book.getBookName()+"\nBook ISBN::"+book.getIsbnNumber() + "\ncost ="+cost+"\n\n");
		return cost;
	}

	@Override
	public int visit(Fruit fruit) 
	{
		int cost = fruit.getPricePerKg()*fruit.getWeight();
		System.out.println(fruit.getName() + " cost = "+cost);
		return cost;
	}

}
