package com.bridgelabz.algorithm;


import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash MOhanty
 * @version 1.1
 * @CreatedOn 13th Nov, 2019
 * 
 * Purpose: To take user input as string Array and Sort The String Array using Insertion SOrt.
 *
 */

public class InsertionSort 
{
	public static void main(String[] args) 
	{
		System.out.println("How Many Numbers of Elements Do u Wnat to Inser? : ");
		int elements = Utility.inputInteger();
		System.out.println("TOtal SIze = " +elements);
		String str[] = new String[elements]; // Total number of words/elements to be taken as input in the string array
		System.out.println("Entre Words To Sort: ");
		
		/**
		 * Loop is to take all the elements in the String array
		 */
		for(int i = 0; i < elements; i++)
		{
			str[i] = Utility.inputString();
			
		}
		String[] strResult = insertionSort(str, str.length); // Method will return string array object that carries the Sorted result
		
		/**
		 *TO PRINT THE WORDS OF ARRAY 
		 */
		
		for(int i = 0; i < elements; i++)
			System.out.print(strResult[i]+" ");
		
	}
	
	/**
	 * 
	 * @param str take input as String type
	 * @param length is of integer type
	 * @return returns the string type data to the calling function
	 * 
	 * This method will sort the given list of words
	 */

	private static String[] insertionSort(String[] str, int length) 
	{
		String temp = " ";
		for(int i = 0; i < length; i++) //'i' is used for the first element in the list
		{
			for(int j = i+1; j < length; j++) // 'j' is used for the next element in the list
			{
				/**
				 * will compare the value located at position str[i] and str[j] lexicographically
				 * and returns 0 if both the items are same else it returns +ve or -ve values.
				 */
				if(str[i].compareTo(str[j]) > 0)
				{
					//swapping both items if first item is greater than the second item
					
					temp = str[i];
					str[i] = str[j];
					str[j] = temp;
				}
			}
		}
		
		return str;
	}

}
