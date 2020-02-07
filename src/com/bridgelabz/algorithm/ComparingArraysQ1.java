package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class ComparingArraysQ1 
{
	public static void main(String[] args) 
	{
		System.out.print("Enter a String: ");
		String str1 = Utility.inputString();
		/*
		 * System.out.print("Enter 2nd String: "); String str2 = Utility.inputString();
		 */
		ComparingArraysQ1 permute = new ComparingArraysQ1();
		permute.permutation(str1, 0, str1.length()-1);
		permute.iteration(str1, 0, str1.length()-1);
	}
	
	//Iterative Method 
	private void iteration(String str2, int startIndex, int lastIndex) 
	{	
		System.out.println("Iterative Method");
		for(int i = startIndex; i <= lastIndex; i++ )
		{
			
			for(int j = i+1; j <= lastIndex; j++)
			{
				
				for(int k = j+1 ; k <= lastIndex; k++)
				{
					System.out.print(str2.charAt(i));
					System.out.print(str2.charAt(j));
					System.out.print(str2.charAt(k));
					System.out.println();
				}
				
			}
			
			
		}
		
	}

	private void permutation(String str1, int startIndex, int endIndex) 
	{
		if(startIndex == endIndex)
			System.out.println(str1);
		else
		{
			for(int i = startIndex; i <= endIndex; i++)
			{
				str1 = swap(str1, startIndex, i);
				permutation(str1, startIndex+1, endIndex);
				str1 = swap(str1, startIndex, i);
			}
		}
	}

	private String swap(String string1, int i, int j) 
	{
		char temp;
		char [] array = string1.toCharArray();
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		
		return String.valueOf(array);
	}

}
