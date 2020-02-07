package com.bridgelabz.design_pattern.singleton_pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose: Reflection can be used to destroy all the above singleton implementation approaches.
 * 			Reflection Implementation in Singleton pattern
 * 
 * 			
 *
 */

public class TestReflectionToDestroySingleton 
{
	public static void main(String[] args) 
	{
		//Accessing Instance of Singleton Eager Initialization.
		//Create the 1st instance
		EagerInitialization eagerInitializationInstance = EagerInitialization.getInstance();
		//Create 2nd instance using Java Reflection API.
		EagerInitialization eagerInitializationTestInstance = null;

		/*
		 * To prevent Singleton failure while due to reflection you have to throw a run-time exception in constructor, 
		 * if the constructor is already initialized and some class to initialize it again.
		 * 
		 * or simply surround the object initialization within a "try-catch-block to get the instance"
		 */
		
		try 
		{
			//For Eager Initialization of Singleton Class
			Class<EagerInitialization> eagerIntializationClass = EagerInitialization.class;
			Constructor<EagerInitialization> constructor = eagerIntializationClass.getDeclaredConstructor();
			constructor.setAccessible(true);
			eagerInitializationTestInstance = constructor.newInstance();
			
			System.out.println("Eager Initialization Instance-1 : "+eagerInitializationInstance.hashCode());
			System.out.println("Eager Initialization Instance-2 : "+eagerInitializationTestInstance.hashCode());
			
			System.out.println("--------------------------------------------------------");
			System.out.println("Lazy Initialization SIngleton Destroy using Reflection\n--------------------------------------------------------");
			//Accessing Instance of Singleton Lazy Initialization.
			LazyInitializtion lazyInitializationInstance = LazyInitializtion.getInstance();
			LazyInitializtion lazyInitializationTestInstance = null;
			
			@SuppressWarnings("rawtypes")
			Constructor[] constructorOfLazyInitializatin = LazyInitializtion.class.getDeclaredConstructors();
			for(@SuppressWarnings("rawtypes") Constructor cons : constructorOfLazyInitializatin)
			{
				 //Below code will destroy the singleton pattern
				cons.setAccessible(true);
				lazyInitializationTestInstance = (LazyInitializtion) cons.newInstance();
				System.out.println("Lazy Initialization Singleton Instance - 1: "+cons.hashCode());
				System.out.println("Lazy Initialization Singleton Instance - 1: "+lazyInitializationInstance.hashCode());
				System.out.println("Lazy Initialization Singleton Instance - 2: "+lazyInitializationTestInstance.hashCode());
				break;
			}
			
		} 
		catch (NoSuchMethodException | IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
}
