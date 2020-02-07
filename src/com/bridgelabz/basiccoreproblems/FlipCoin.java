package com.bridgelabz.basiccoreproblems;

import com.bridgelabz.utility.Utility;
/**
 * 
 * @author Bikash Mohanty
 * @Version 1.0
 * @Created on: 12th Nov, 2019
 *
 *Purpose: To find the percentage of Heads and Tails
 *
 */

public class FlipCoin 
{
	public static void main(String[] args) 
	{
		int heads = 0; 
		int tails = 0; 
		int counter = 1;
		double randNum = 0.0; //will hold Random Numbers
		boolean temp = false;
		
		while(!temp)
		{

			System.out.println("How Many Times The Coin Should Flip: ");
			int flips = Utility.inputInteger();
			if(Utility.isPositive(flips)) //if entered number is positive then the program will execute
			{
				System.out.println("Counter \t\t RnadomlyFlipped \t\t Heads/Tails"); 
				System.out.println("_________________________________________________________________________\n");
				while(counter <= flips)
				{
					randNum = Utility.randomNumber();
					System.out.print(counter + "\t\t\t" + randNum);

					if(randNum < 0.5)
					{
						heads++;
						System.out.println("\t\t\t heads");
					}
					else
					{
						tails++;
						System.out.println("\t\t\t tails");
					}
					counter++;
					temp = true;
				}

				System.out.println();
				System.out.println("Number of Heads = " + heads);
				System.out.println("Number of Tails = " + tails);
			}
			else
				System.out.println("Enter a Positive Number");
		}
	}

}
