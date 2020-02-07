package com.bridgelabz.datastructure;

/**
 * @Author   :  Bikash Mohanty
 * @Version  :  1.0
 * @CreatedOn     :  19th Nov 2019
 * Purpose   :  Read the Text from a file, split it into words and arrange it as Linked List.
 *				Take a user input to search a Word in the List. If the Word is not found then 
 *				add it to the list, and if it found then remove the word from the List. In the
 *				end save the list into a file
 */
import java.io.*;
import com.bridgelabz.utility.LinkedListFinal;
import com.bridgelabz.utility.Utility;

public class UnOrderedList 
{ 
	public static void main(String[] args) throws IOException 
	{

		LinkedListFinal<String> list = new LinkedListFinal<String>();

		System.out.println("Enter the word you want to search :");

		String item = Utility.inputStringLine();

		//read from file and assign into String s

		String path = Utility.readFromFile("C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Assessments\\text1.txt");

		String []words = path.split(" ");

		//adding in data into linkedlist

		for (String word : words) 

			list.add(word);



		//to write into file

		FileWriter writer = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Assessments\\text1.txt");

		//logic to search the word,remove and add

		if (list.search(item) == true) 
		{
			list.removeItem(item);    
		} 
		else 
		{
			list.add(item);
		}

		list.display();

		int size = list.size();
		
		

		for (int i = 0; i < size-1; i++) 
		{
			writer.write(list.pop(0)+ " ");
		}
		writer.close();
	}

}
