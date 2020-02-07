package com.bridgelabz.design_pattern.singleton_pattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class TestSerializedSingleton 
{

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectOutput out = null;
		SerializedSingleton serializedSingletonInstance1 = SerializedSingleton.getInstance();
		out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\src\\SerializedFile.txt"));
		
		out.writeObject(serializedSingletonInstance1);
		System.out.println("Hello");
		System.out.println("instance1 hashCode=" + serializedSingletonInstance1.hashCode());
		out.close();

		//Deserialization From File to Object
		ObjectInput in = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\src\\SerializedFile.txt"));
		SerializedSingleton serializedSingletonInstance2 = (SerializedSingleton) in.readObject();
		System.out.println("instance2 hashCode=" + serializedSingletonInstance2.hashCode());
		in.close();
	}

}
