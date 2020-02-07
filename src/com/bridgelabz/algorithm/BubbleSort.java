package com.bridgelabz.algorithm;

import com.bridgelabz.utility.InputUtility;

/**
 * 
 * @author Bikash MOhanty
 * @version 1.1
 * @CreatedOn 13th Nov, 2019
 * 
 * Purpose: To take user input as integer Array and Sort The Array using Bubble SOrt.
 *
 */
public class BubbleSort 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Total Nos. of Array Elements You Want To sort: ");
		int totalElements = InputUtility.inputInteger();
		int arr[] = new int[totalElements];
		
		System.out.println("Enter " +totalElements+ " Array Elements: ");
		
		/**
		 * Loop is to store all the elements in the String array
		 */
		
		for(int i = 0; i < totalElements; i++)
			arr[i] = InputUtility.inputInteger();
		
		BubbleSort bs = new BubbleSort();
		bs.sort(arr, totalElements);
	}
	
	/**
	 * 
	 * @param arr is the array that holds the array elements
	 * @param arrLength is the Length of the Array
	 */

	private void sort(int[] arr, int arrLength) 
	{
		System.out.println("Before Sorting");
		//prints the array before sorting
		for(int i = 0; i < arrLength; i++)
			System.out.print(arr[i]+ " ");
		
		System.out.println("\nAfter Sorting\n____________________________________\n");
		for(int i = 0; i < arrLength-1; i++)
		{
			/**
			 * this loop will execute i-1 times as the last index will be stored in 'i'
			 * we compare 'jth index' with the next index for sorting
			 */
			for(int j = 0; j < arrLength-i-1; j++)
			{
				int temp;
				//swap arr[j+1] and arr[i]
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
							
				}
			}
			
		}
		//prints the array
		for(int i = 0; i < arrLength; i++)
		{
			System.out.print(arr[i]+ " ");
		}
			
		
	}

}
