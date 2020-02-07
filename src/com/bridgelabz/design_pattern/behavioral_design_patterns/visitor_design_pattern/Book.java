package com.bridgelabz.design_pattern.behavioral_design_patterns.visitor_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: Book Class
 *
 */
public class Book implements ItemElement 
{

	private int price;
	private String isbnNumber;
	private String bookName;
	
	public Book(int cost, String isbn, String bookNames)
	{
		this.price=cost;
		this.isbnNumber=isbn;
		this.bookName = bookNames;
	}
	
	public int getPrice() 
	{
		return price;
	}

	public String getIsbnNumber() 
	{
		return isbnNumber;
	}
	
	public String getBookName() 
	{
		return bookName;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) 
	{
		return visitor.visit(this);
	}

}
