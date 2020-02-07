package com.bridgelabz.junit;

/**
 * @author Bikash Mohanty
 * @version 1.0
 * @created 21st Nov 2019
 * 
 * Purpose : to calculate the Binary of a given decimal and decompose the input into a power of 2
 * 			 i.e 106 = 2 + 8 + 32 + 64
 */

import com.bridgelabz.utility.Utility;

public class ToBinary 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter a Decimal Number to convert into Binary :");
		int decimal = Utility.inputInteger();
		long x = decimal;
		checkBinary(decimal, x);		
	}
	
	public static void checkBinary(int decimal, long x) 
	{
		int i;
		int [] binary = new int[1000];
		System.out.println("Binary is: ");
		//To generate the binary number from the decimal number until decimal is equal to 0
		for (i = 0; decimal != 0; decimal/=2,i++) 
		{
			binary[i]= decimal % 2;	//storing the binary number in an Array
		}
		

		for (int j = i-1; j >= 0; j--) 
		{
			System.out.print(binary[j]); //Reversing the Array to get the Binary Number Equivalent to Decimal  number
		}
			
		System.out.println();
		
		//The following loop will check the indexes of the Array and and make them power of two where
		//it finds '1' in the array.

		for(int k = 0; k < binary.length; k++)
		{
			if(binary[k] == 1) //will check the index is 1 or not
				System.out.print((int)(Math.pow(2, k))+ " ");
		}
	}

}
