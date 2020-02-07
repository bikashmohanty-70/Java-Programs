package com.bridgelabz.design_pattern.singleton_pattern;

public class TestEagerInitialization 
{

	public static void main(String[] args) 
	{
		//access instance of SingletonCls using getInstance() method
		EagerInitialization instance1 = EagerInitialization.getInstance();
		EagerInitialization instance2 = EagerInitialization.getInstance();
		
		instance1.setMessage("From Main Class");	
		System.out.println(instance1.getMessage());
		
		//Checking if hashCode of both the instances of Singleton class are same using Eager Initialization 
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}

}
