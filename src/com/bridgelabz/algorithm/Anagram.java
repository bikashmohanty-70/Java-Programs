package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @since 15th Nov 2019
 * 
 * Purpose: The following program will check two strings whether one of them is Anagram of other or not
 *
 */

public class Anagram 
{

	public static void main(String[] args) 
	{
		System.out.print("Enter A string:");
		String str1 = Utility.inputString();
		System.out.println("Enter Anagram Of that String: ");
		String str2 = Utility.inputString();
		
		if(Utility.isAnagram(str1, str2))
			System.out.println("The Strings Are Anagram");
		else
			System.out.println("Strings are NOT Anagram");

	}

}
