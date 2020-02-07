package com.bridgelabz.design_pattern.behavioral_design_patterns.visitor_design_pattern;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.1
 * 
 * Purpose: main Class implementations
 *
 */

public class ShoppingCartClient 
{

	public static void main(String[] args) 
	{
		System.out.println("ENter Book Name: ");
		String bookName = Utility.inputString();
		ItemElement[] items = new ItemElement[]{new Book(20, "1234", bookName),
				new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple")};
		
		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);
	}

	private static int calculatePrice(ItemElement[] items) 
	{
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		
		int sum=0;
		for(ItemElement item : items)
		{
			System.out.println(item);
			sum = sum + item.accept(visitor);
		}
		return sum;
	}

}
