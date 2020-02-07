package com.bridgelabz.basiccoreproblems;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @Created on: 12th Nov, 2019
 * 
 * Purpose: TO check whether a year is Leap Year or not.
 *
 */

public class LeapYear 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter any Year: ");
		int year = Utility.inputInteger();
		boolean isChecking = false;
		while(!isChecking)
		{
			if(Utility.countDigits(year) == 4) //@param year : passed to countDigits of Utility class to check the number of digits is equal to 4 or not
			{
				if(Utility.isLeapYear(year)) //@param year: passed to is LeapYear of Utility class to check the entered year is Leap Year or Not.
					System.out.println(+year+ " is a Leap Year");
				else
					System.out.println(+year+ " is not a Leap Year");
				isChecking = true;
			}
			else
				System.out.println("You Must Enter a year of 4 digits.");
		}
		
	}

}
