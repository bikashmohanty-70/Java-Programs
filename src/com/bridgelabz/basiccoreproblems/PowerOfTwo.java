package com.bridgelabz.basiccoreproblems;

import com.bridgelabz.utility.InputUtility;
import com.bridgelabz.utility.Utility;
/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @crested: 12th Nov, 2019
 * 
 *  Purpose: Program is to calculate the nth power of 2
 *
 */
public class PowerOfTwo 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter a Number less than 31 to print power of 2 from 1 to N:  ");
		int number = InputUtility.inputInteger();
		int leap = 0;
		if(number > 0 && number < 31)
		{
			for(int i = 0; i <= number; i++)
				//System.out.println(Utility.powerOfTwo(number, i));
				leap = Utility.powerOfTwo(number, i);
			if(!Utility.isLeapYear(leap))
				System.out.println("2 ^ "+number+ " = "+leap+ " Is a Leap Year");
			else
				System.out.println("2 ^ "+number+ " = "+leap+ " is not a Leap Year");
				
		}
		
		

	}

}
