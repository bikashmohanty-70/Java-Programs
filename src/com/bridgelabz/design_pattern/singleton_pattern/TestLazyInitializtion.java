package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * 
 *
 */
public class TestLazyInitializtion 
{

	public static void main(String[] args) 
	{
		LazyInitializtion instance = LazyInitializtion.getInstance();
		instance.setMessgae("From Main Class");
		displayMessage();
	}
	
	//This Method will get the instance that is already created during the call in main() method, for the first time.
	private static void displayMessage() 
	{
		LazyInitializtion instance = LazyInitializtion.getInstance();
		System.out.println(instance.getMessgae());
	}

}
