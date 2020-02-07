package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose: Singleton Class Implementation with Eager Intialization / Early Loading
 *
 */
public class EagerInitialization 
{
	//Singleton Instance, Which will be created in the JVM during start of the application
	private static final EagerInitialization INSTANCE = new EagerInitialization();
	
	private String message = "";
	
	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message) 
	{
		this.message = message;
	}

	//making constructor private so that no other class could use the default constructor
	private EagerInitialization() {}
	
	//the method which gives access to the only instance of SingletonCls
	public static EagerInitialization getInstance()
	{
		return INSTANCE;
	}

}
