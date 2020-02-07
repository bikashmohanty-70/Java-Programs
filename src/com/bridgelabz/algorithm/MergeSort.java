package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class MergeSort 
{
	int [] array;
	int[] tempArray;
	int length;

	public static void main(String[] args) 
	{
		MergeSort merge1 = new MergeSort();
	
		 System.out.println("How MAny Elements do u want to Insert?"); int
		 totalElements = Utility.inputInteger();
		 
		 int [] inputArray = new int[totalElements];
		 
		 System.out.print("\nEnter array elements to sort Using Merge Sort: ");
		 for(int i = 0; i < totalElements; i++) inputArray[i] =
		 Utility.inputInteger();
		 
		 System.out.println("Before Sorting"); 
		 
		 for(int i = 0; i < totalElements; i++)
			 System.out.print(inputArray[i] + " " );
		 
		
		
		merge1.sort(inputArray);
		System.out.println("After Sorting:\n");
		for (int i : inputArray) 
		{
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int[] inputArray) 
	{
		this.array = inputArray;
		this.length = inputArray.length;
		this.tempArray = new int[length];
		
		divideArray(0, length-1);
	}
	
	/**
	 * 
	 * @param lowerIndex is the lower index of the array
	 * @param higherIndex is the last/higher index of the array
	 * 
	 * Purpose: THis method work on the Divide n conquer principle, it will divide the array in two parts
	 * until individual items of the array left, the it will call the mergSortBothArray
	 */

	public void divideArray(int lowerIndex, int higherIndex) 
	{
		if(lowerIndex < higherIndex)
		{
			int middle = lowerIndex + (higherIndex - lowerIndex)/2;
			
			divideArray(lowerIndex, middle); //This recursive function is used for sorting left side array
			
			divideArray(middle + 1 , higherIndex); //This recursive function is used for sorting right side array
			
			
			mergeSortBothArray(lowerIndex,middle,higherIndex);
		}
	}

	public void mergeSortBothArray(int low, int mid, int high) 
	{
		for(int i = low; i <= high; i++)
		{
			tempArray[i] = array[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		
		while(i <= mid && j <= high)
		{
			if(tempArray[i] <= tempArray[j])
			{
				array[k] = tempArray[i];
				i++;
			}
			else
			{
				array[k] = tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid)
		{
			array[k] = tempArray[i];
			k++;
			i++;
		}
	}

}
