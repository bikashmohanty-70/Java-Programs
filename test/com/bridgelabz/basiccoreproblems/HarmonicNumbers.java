package com.bridgelabz.testcases;

import com.bridgelabz.utility.Utility;

/**
 *  
 * @author Bikash Mohanty
 * @Created on: 12th Nov, 2019
 * @version 1.0
 * 
 * Purpose: Java program to find N-th Harmonic Number
 *
 */


class HarmonicNumbers 
{ 

	//Function to find nth Harmonic Number 
	static double harmonicNumbers(int N) 
	{ 
		// H1 = 1 
		float harmonic = 1; 

		// loop to apply the formula 
		// Hn = H1 + H2 + H3 ... + Hn-1 + Hn-1 + 1/n 
		for (int i = 2; i <= N; i++) 
		{ 

			System.out.println(harmonic+" / "+i+ " = "+harmonic+ "");
			harmonic += (float)1 / i; 
		} 

		return harmonic; 
	} 

	//Driver Code 

	public static void main (String[] args) { 
		System.out.println("Enter a NUmber: ");
		int num = Utility.inputInteger();

		System.out.print(harmonicNumbers(num)); 

	} 
} 