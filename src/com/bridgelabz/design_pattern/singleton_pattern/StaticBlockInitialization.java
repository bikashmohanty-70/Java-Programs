package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 *   Purpose: 	Static block initialization implementation is similar to eager initialization, 
 *   			except that instance of class is created in the static block that provides option 
 *   			for exception handling.
 *
 */
public class StaticBlockInitialization 
{
	private static StaticBlockInitialization staticBlockInitialization_instance;
	
	//private constructor to avoid client applications to use constructor
	private StaticBlockInitialization() {}
	
	//static block initialization for exception handling
	static
	{
		try 
		{
			staticBlockInitialization_instance = new StaticBlockInitialization();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Exception occured in creating Singleton Class Object");
		}
	}

	private static String message = "";

	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		StaticBlockInitialization.message = message;
	}

	public static StaticBlockInitialization getInstance()
	{
		return staticBlockInitialization_instance;
	}

}
