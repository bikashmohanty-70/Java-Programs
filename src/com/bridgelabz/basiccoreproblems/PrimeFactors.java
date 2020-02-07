package com.bridgelabz.basiccoreproblems;

import java.util.ArrayList;
import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @Created 12th Nov, 2019
 * 
 * purpose: To calculate all prime factors of a number
 *
 */
class checkFactors
{
	/**
	 *@checkFactors constructor calculate the prime factors.
	 *@param num : a positive integer that carries the value entered by the user
	 */
	public checkFactors(int num)
	{
		int number = num; // Holds the value of num
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 2; i <= num; i++)	//loop will starts from 2, as 2 is the 1st prime number in NATURAL NUMBER SYSTEM
		{
			while(num % i == 0)
			{
				list.add(i);
				num /= i;
			}
		}

		System.out.println("Prime factors of "+number+ " are " + list);

	}
}
public class PrimeFactors 
{


	public static void main(String[] args) 
	{
		System.out.println("Enter a Number: ");
		int num = Utility.inputInteger();
		@SuppressWarnings("unused")
		checkFactors check = new checkFactors(num); //passing value to the constructor
		

	}

}
