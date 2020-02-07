package com.bridgelabz.functional_programs;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utility.InputUtility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @since 13th NOv, 2019
 * 
 * Purpose: To count the number of triplets that sum to exactly 0.
 * it'll take N number of integers input and compute the triplets i.e a[i]+a[j]+a[k] = 0
 *
 */

public class Triplets 
{
	static int totalElements;

	public static void main(String[] args) 
	{
		System.out.println("Enter Total number of Array Elements you want to insert: ");
		totalElements = InputUtility.inputInteger();
		
		int [] arr = new int[totalElements];
		System.out.println("Enter " +totalElements+ " Array Elements: ");
		
		// loop iterates to insert all the elements into the array
		
		for (int i = 0; i < arr.length; i++) 
		{
			arr[i] = InputUtility.inputInteger();
		}
		
		System.out.print("Triplets ");
		triplets(arr, arr.length);
	}

	public static List<Integer> triplets(int[] arr, int length) 
	{
		List<Integer> list = new ArrayList<Integer>();
		boolean found = false;// boolean is used as a mark if no triplets found
	
		for (int i = 0; i < length-2; i++) // 'i' iterates through 0th index to length -2
		{
			for (int j = i+1; j < length-1; j++) //'j' iterates from the next immediate index i.e from 1st index to length-1 index
			{
				for (int k = j+1; k < length; k++) // 'k' iterates from the next index as of 'j' and loop until the array actual length
				{
					if (arr[i]+arr[j]+arr[k] == 0) // comparing each indexes for getting triplet as 0
					{
						System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);
						found = true;
					}
				}
				
			}
			
		}
		
		if(!found)
		{
			System.out.print("Not Found");
		}
		System.out.println(list);
		return list;
		
	}

}
