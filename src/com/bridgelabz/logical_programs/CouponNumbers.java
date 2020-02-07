package com.bridgelabz.logical_programs;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @created_on: 13th Nov, 2019
 * 
 * Purpose: is to find the random numbers needed to generate distinct coupon numbers 
 * from a given N distinct COupon numbers.
 *
 */

public class CouponNumbers 
{
	// return a random coupon between 0 and n-1
	public static int coupon(int n)
	{
		return (int) (Math.random()*n);
	}
	
	
	public static void main(String[] args) 
	{
		System.out.println("Enter a card Number to Draw: ");
		int n = Utility.inputInteger();
		boolean[] collect = new boolean[n];// collect[i] = true if card type i already collected
		int count = 0; 					  // number of cards collected
		int notSame = 0;				 // number of distinct card types collected

		// for number of cards you collect before obtaining one of each of the n types
		while (notSame < n)
		{
			int card = coupon(n);			// pick a random card 
			System.out.println(card);	   // one more card
			count++;
			if(!collect[card])			 // discovered a new card type
			{
				notSame++;
				collect[card] = true;
			}
		}
		System.out.println("Total Random Numbers needed: "+count);

	}

}
