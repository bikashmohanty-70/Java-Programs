package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose: This approach for Singleton class doesn’t require synchronization.
 *
 */
public class TestBillPughSingletonImplementation 
{

	public static void main(String[] args) 
	{
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() 
			{
				BillPughSingletonImplementation instance1 = BillPughSingletonImplementation.getInstance();
				System.out.println("threadSafe_Instance1: "+instance1.hashCode());
				instance1.setMessgae("From Main Class");
				instance1.getMessgae();
				
				//Creating Lazy Initialization instance which is not synchronized
				LazyInitializtion lazyInitializationInstance1 = LazyInitializtion.getInstance();
				System.out.println("lazyInitialization_instance1: "+lazyInitializationInstance1.hashCode());

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() 
			{
				BillPughSingletonImplementation instance2 = BillPughSingletonImplementation.getInstance();
				System.out.println("threadSafe_Instance2: "+instance2.hashCode());
				
				//Creating Lazy Initialization instance which is not synchronized
				LazyInitializtion lazyInitializationInstance2 = LazyInitializtion.getInstance();
				System.out.println("lazyInitialization_instance2: "+lazyInitializationInstance2.hashCode());

			}
		});
		
		thread1.start();
		thread2.start();
	}

}
