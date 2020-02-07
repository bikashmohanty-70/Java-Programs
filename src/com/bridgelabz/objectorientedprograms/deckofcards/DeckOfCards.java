package com.bridgelabz.deckofcards;


/**
 * @author Bikash Mohanty
 * @since 4th Dec 2019
 * @version 1.0
 * 
 * Purpose: This class implements and works on what ever the data and services main method asking for
 */



import java.util.Random;

public class DeckOfCards 
{
	public static int[][] cards = new int[4][13];
	
	/**
	 * 
	 * @param playerNumber --> integer type
	 * to print the cards of each Player 
	 *
	 */
	
	public static void printPlayersCards(int playerNumber) 
	{
		for (int cardType = 0; cardType < 4; cardType++) 
		{
			for (int cardNumbers = 0; cardNumbers < 13; cardNumbers++) 
			{
				if (cards[cardType][cardNumbers] == playerNumber) 
				{
					System.out.print(getCardType(cardType)+ "(" +getCardNumber(cardNumbers)+") \t");
				}
			}
			
		}
		System.out.println("\n");
	}

	/**
	 * 
	 * @param cardNumbers --> integer
	 * @return String
	 */
	private static String getCardNumber(int cardNumbers) 
	{
		switch (cardNumbers) 
		{
			case 0:
				return "Ace";
			case 1:
				return "2";
			case 2:
				return "3";
			case 3:
				return "4";
			case 4:
				return "5";
			case 5:
				return "6";
			case 6:
				return "7";
			case 7:
				return "8";
			case 8:
				return "9";
			case 9:
				return "10";
			case 10:
				return "Jack";
			case 11:
				return "Queen";
			case 12:
				return "King";

		default:
			System.out.println("No Such Card Available");
			return null;
		}
	}

	/**
	 * 
	 * @param cardType --> integer
	 * @return -> String
	 */
	private static String getCardType(int cardType) 
	{
		switch (cardType) 
		{
			case 0:
				return "Clubs";
			case 1:
				return "Spades";
			case 2:
				return "Diamond";
			case 3:
				return "Hearts";

		default:
			System.out.println("No Such Card Available");
			return " ";
		}
	}
	
	//This method is responsible for shuffling the deck of cards

	public static void alotShuffledCards(int playerNumber) 
	{
		for (int i = 0; i < 9; i++) 
		{
			cardShuffling(playerNumber);
		}		
	}
	
	//This Method is responsible for Distributing the shuffled cards

	private static void cardShuffling(int playerNumber) 
	{
		Random randomCards = new Random();
		int cardType = randomCards.nextInt(4);
		int cardNumbers = randomCards.nextInt(13);
		
		if (cards[cardType][cardNumbers] != 0) {

			cardShuffling(playerNumber);

		} 
		else 
		{

			cards[cardType][cardNumbers] = playerNumber;

		}

	}

}
