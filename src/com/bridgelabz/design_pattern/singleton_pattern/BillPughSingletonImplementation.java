package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * purpose: Bill Pugh Singleton implementation
 *
 */
public class BillPughSingletonImplementation 
{
	private BillPughSingletonImplementation()
	{
		System.out.println("Bill Pugh Singleton Private Constructor");
	}
	
	/*	private inner static class that contains the instance of the singleton class. 
		When the singleton class is loaded, SingletonHelper class is not loaded into 
		memory and only when someone calls the getInstance method, this class gets 
		loaded and creates the Singleton class instance.
	*/
	private static class SingletonHelper
	{
		private static final BillPughSingletonImplementation BILL_PUGH_INSTANCE = new BillPughSingletonImplementation();
	}
	
	public static BillPughSingletonImplementation getInstance()
	{
		return SingletonHelper.BILL_PUGH_INSTANCE;
	}
	
	private String messgae = "";
	

	public String getMessgae() 
	{
		return messgae;
	}

	public void setMessgae(String messgae) 
	{
		this.messgae = messgae;
	}

}
