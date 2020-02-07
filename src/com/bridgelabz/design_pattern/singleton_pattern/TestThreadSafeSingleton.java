package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash MOhanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose:	if synchronized then the singleton class concept will be of no value in case of thread.
 * 			So to make it thread safe getInstance() method synchronized.
 *
 */
public class TestThreadSafeSingleton 
{

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException 
	{
		//Thread 1

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() 
			{
				ThreadSafeSingleton threadSafe_Instance1 = ThreadSafeSingleton.getInstance();
				System.out.println("threadSafe_Instance1: "+threadSafe_Instance1.hashCode());
				threadSafe_Instance1.setMessgae("From Main Class");
				threadSafe_Instance1.getMessgae();
				
				//Creating Lazy Initialization instance which is not synchronized
				LazyInitializtion lazyInitialization_instance1 = LazyInitializtion.getInstance();
				System.out.println("lazyInitialization_instance1: "+lazyInitialization_instance1.hashCode());

			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() 
			{
				ThreadSafeSingleton threadSafe_Instance2 = ThreadSafeSingleton.getInstance();
				System.out.println("threadSafe_Instance2: "+threadSafe_Instance2.hashCode());
				
				//Creating Lazy Initialization instance which is not synchronized
				LazyInitializtion lazyInitialization_instance2 = LazyInitializtion.getInstance();
				System.out.println("lazyInitialization_instance2: "+lazyInitialization_instance2.hashCode());

			}
		});
		
		thread1.start();
		thread2.start();

	}

}
