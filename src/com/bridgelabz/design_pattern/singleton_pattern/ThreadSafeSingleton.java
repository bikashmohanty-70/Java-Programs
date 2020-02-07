package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @since 7th Dec 2019
 *
 * Purpose: The easier way to create a thread-safe singleton class is to make the global access method
 * 			synchronized, so that only one thread can execute this method at a time.
 */
public class ThreadSafeSingleton 
{
	private static ThreadSafeSingleton threadSafe_Instance;
	
	private ThreadSafeSingleton() 
	{
		System.out.println("Singleton instance created using Thread Safe SingleTon.");
	}
	
	//Using synchronized
	public static synchronized ThreadSafeSingleton getInstance()
	{
		if(threadSafe_Instance == null)
		{
			threadSafe_Instance = new ThreadSafeSingleton();
			System.out.println("Instance of Thread Safe created for the first time");
		}
		return threadSafe_Instance;
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
