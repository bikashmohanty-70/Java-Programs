package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash MOhanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose: To overcome the situation with Reflection, Joshua Bloch suggests the use of Enum to implement 
 * 			Singleton design pattern as Java ensures that any Enum value is instantiated only once in a Java program. 
 * 			Since Java Enum values are globally accessible, so is the singleton.
 *
 */
public class EnumSingletonImplementation 
{
	public static void main(String[] args) 
	{
		EnumSingleton instance1 = EnumSingleton.INSTANCE;
		instance1.i = 5;
		instance1.show(); // Calling show() using instance1
		System.out.println("Instance1 : "+instance1.hashCode());
		
		/*
		 * Without Enum We might get the value of instance1.show() as 5 for no matter how many time you call the method
		 */
		
		System.out.println("----------------------------------\nInstance 2\n----------------------------------");
		EnumSingleton instance2 = EnumSingleton.INSTANCE;
		instance2.i = 8;
		instance1.show(); // Calling show() using instance1
		System.out.println("Instance2 : "+instance2.hashCode());
	}
}

enum EnumSingleton
{
	INSTANCE;
	int i;
	
	public void show()
	{
		System.out.println(i);
	}
}