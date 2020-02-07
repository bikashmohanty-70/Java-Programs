package com.bridgelabz.junit;

import com.bridgelabz.utility.InputUtility;

public class VendingMachine 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter Amount: ");
		int amount = InputUtility.inputInteger();
		/**
		 * @param: Calling method name with amount needed and the array of money present
		 * 		   in the vending machine as parameter.
		 */
		System.out.println("\nTotal Number Change : "+minCoin(amount, new int[] {1000, 500, 100, 50, 10, 5, 2, 1}));
	}

	public static int minCoin(int amount, int[] change) 
	{
		/*
		 * int [] combinations = new int[amount+1]; combinations[0] = 1; for (int notes
		 * : change) { for (int i = 0; i < combinations.length; i++) { if(i >= notes)
		 * combinations[i] += combinations[i-notes]; }
		 * 
		 * } return combinations[amount];
		 */
		
		int notes = 0;
		int total = 0;
		
		/**
		 * will calculate minimum number of changes until amount become 0 i.e amount to be 0.
		 */
		
		for (int i = 0; i < change.length; i++) 
		{
			if (amount <= 0)
				break;
			if(change[i] <= amount) //checks whether array elements are less than the amount or not
			{
				notes += amount/change[i];
				total = amount/change[i];
				if(change[i] < 10) // To check whether Notes/coins required 
					System.out.println(total+" coin(s) of "+change[i]+ " required");
				else
					System.out.println(total+" NOTE(s) of "+change[i]+ " required");
				amount = amount % change[i];
			}
		}
		return notes;
	}

}
