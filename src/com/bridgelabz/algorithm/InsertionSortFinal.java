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

public class InsertionSortFinal 
{
		/*Function to sort array using insertion sort*/
		void sort(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i = 1; i < n; ++i) { 
				int key = arr[i]; 
				int j = i - 1; 

				/* Move elements of arr[0..i-1], that are 
				greater than key, to one position ahead 
				of their current position */
				while (j >= 0 && arr[j] > key) { 
					arr[j + 1] = arr[j]; 
					j = j - 1; 
				} 
				arr[j + 1] = key; 
			} 
		} 

		/* A utility function to print array of size n*/
		static void printArray(int arr[]) 
		{ 
			int n = arr.length; 
			for (int i = 0; i < n; ++i) 
				//System.out.print(arr[i] + " ");
				System.out.print(String.valueOf(arr[i])+" ");

			System.out.println(); 
		} 

		// Driver method 
		public static void main(String args[]) 
		{ 
			System.out.println("How Many Numbers of Elements Do u Wnat to Inser? : ");
			int elements = Utility.inputInteger();
			System.out.println("TOtal SIze = " +elements);
			String str[] = new String[elements]; // Total number of words/elements to be taken as input in the string array
			System.out.println("Entre Numbers To Sort: ");
			int arr[] = new int[elements];
			/**
			 * Loop is to take all the elements in the String array
			 */
			for(int i = 0; i < elements; i++)
			{
				str[i] = Utility.inputString();
				arr[i] = Integer.parseInt(str[i]);
				
			}

			InsertionSortFinal ob = new InsertionSortFinal(); 
			ob.sort(arr); //Instantiation of InsertionFInal class to use the reference to call the sort Method

			printArray(arr); 
		} 

}
