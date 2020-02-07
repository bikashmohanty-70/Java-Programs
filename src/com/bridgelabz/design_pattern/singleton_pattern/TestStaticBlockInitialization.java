package com.bridgelabz.design_pattern.singleton_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0 
 *
 */
public class TestStaticBlockInitialization 
{
	public static void main(String[] args) 
	{
		StaticBlockInitialization instance1 = StaticBlockInitialization.getInstance();
		instance1.setMessage("From Main Class Instance-1 msg");
		
		System.out.println(instance1.getMessage());
		System.out.println(instance1.hashCode());
		System.out.println(displayAnotherInstance());
	}

	private static String displayAnotherInstance() 
	{
		StaticBlockInitialization instance2 = StaticBlockInitialization.getInstance();
		instance2.setMessage("From Main Class Instance-2 msg");
		System.out.println(instance2.hashCode());
		return instance2.getMessage();
	}

}
