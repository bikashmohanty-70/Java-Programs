package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose:	Lazy initialization method to implement Singleton pattern creates 
 * 			the instance in the global access method.
 *
 */
public class LazyInitializtion 
{
	private static LazyInitializtion lazyInitialization_instance;

	//private constructor to avoid client applications to use constructor
	private LazyInitializtion() 
	{
		System.out.println("Singleton instance created using Lazy Initialization."); 
	}
	
	//This Method will allow to create only one instance of Singleton class using Lazy Initialization 
	//If the reference variable of the class is null then it'll create an Object
	//If reference variable is not null the it'll return the object created earlier
	public static LazyInitializtion getInstance()
	{
		if(lazyInitialization_instance == null)
		{
			lazyInitialization_instance = new LazyInitializtion();
			System.out.println("Instance of Lazy Initialization created for the first time");
		}
//		else
//			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		return lazyInitialization_instance;
	}
	
	private static String messgae = "";

	public String getMessgae() 
	{
		return messgae;
	}

	public void setMessgae(String messgae) 
	{
		LazyInitializtion.messgae = messgae;
	}

}
