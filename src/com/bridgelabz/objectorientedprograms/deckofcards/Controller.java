/**
 * @author Bikash Mohanty
 * @since 3rd Dec 2019
 * @version 1.0
 * 
 * Purpose: Main method that is responsible for adding 4 players and distributing cards randomly Shuffled
 * 			among those 4 players 
 */

package com.bridgelabz.deckofcards;

import com.bridgelabz.utility.Utility;

public class Controller 
{

	public static String [] name = new String[4];
	
	public static void main(String[] args) 
	{
		System.out.println(name.length);
		for (int playerNumber = 0; name.length > playerNumber; playerNumber++) 
		{
			System.out.print("Enter Player "+(playerNumber+1)+"'s Name: ");
			name[playerNumber] = Utility.inputString();
			
		}
		
		for (int playerNumber = 0; name.length > playerNumber; playerNumber++) 
		{
			DeckOfCards.alotShuffledCards(playerNumber+1);
			System.out.print(name[playerNumber]+"'s Cards: ");
			DeckOfCards.printPlayersCards(playerNumber+1);
		}
		
		
	}

}
