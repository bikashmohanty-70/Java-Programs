package com.bridgelabz.design_pattern.singleton_pattern;

import java.io.Serializable;

/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 * 
 * Purpose: Serialization and Singleton implementation, we need to implement 
 * 			Serializable interface in Singleton class so that we can store 
 * 			its state in the file system and retrieve it at a later point of time.
 *
 */
public class SerializedSingleton implements Serializable
{

	private static final long serialVersionUID = -7604766932017737115L;
	//Private Constructor
	private SerializedSingleton() {}

	private static class SingletonHelper
	{
		private static final SerializedSingleton INSTANCE = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance()
	{
		return SingletonHelper.INSTANCE;
	}

	/**
	 * 
	 * @return --> object from getInstance()
	 * 
	 * Purpose: readResolve() will resolve the two object having different HashCode.
	 * 			To prevent creation of another instance you have to provide the 
	 * 			implementation of readResolve() method. readResolve() replaces the 
	 * 			object read from the stream. This ensures that nobody can create another 
	 * 			instance by serializing and deserializing the singleton.
	 */
	protected Object readResolve() 
	{
		return getInstance();
	}
}
