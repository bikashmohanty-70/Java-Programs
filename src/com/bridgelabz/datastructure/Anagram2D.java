package com.bridgelabz.datastructure;

/**
 * @author Bikash Mohanty
 * @Since: 24th Nov 2019
 * @Version: 1.0
 * 
 * purpose: Creating a 2D array and storing all the anagrams that are prime numbers between 0 - 1000
 */

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utility.Utility;

public class Anagram2D 
{

	public static void main(String[] args) 
	{
		List<String> primeList = new ArrayList<>();
		List<Integer> anagramList = new ArrayList<>();
		
		
		int [][] arr = new int[10][79];
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 79; j++) 
			{
				arr[i][j]=0;
					
			}
			
		}
		for(int i = 0; i < 1000; i++)
			if(Utility.isPrime(i))
				primeList.add(Integer.toString(i));
		System.out.println(primeList);
		
		//Below block of code will check the PrimeList and find the Anagrams in that List
		
		for (int k = 0; k < primeList.size(); k++) 
		{
			for (int k2 = k+1; k2 < primeList.size(); k2++) 
			{
				if (Utility.isAnagram(primeList.get(k), primeList.get(k2))) //Checking whether the number in PrimeList is anagram or not
				{
					//Integer.parseInt(primeList.get(k));
					anagramList.add(Integer.parseInt(primeList.get(k))); // if the number is anagram then add in anagramList 
					System.out.println(primeList.get(k)+ " and "+primeList.get(k2)+ " are Anagram");
				}
			}
		}
		System.out.println(anagramList);
		
		
		System.out.println(anagramList.size()+" size");
		for (int i = 0; i < 10; i++) 
		{
			
			for (int j = 0; j < 79; j++) 
			{
				int number = anagramList.get(j);
				if(number / 100 == 0)
				{
					arr[0][j] = anagramList.get(j);
				}
				else if(number / 100 == 1)
				{
					arr[1][j] = anagramList.get(j);
				}
				else if(number / 100 == 2)
				{
					arr[2][j] = anagramList.get(j);
				}
				else if(number / 100 == 3)
				{
					arr[3][j] = anagramList.get(j);
				}
				else if(number / 100 == 4)
				{
					arr[4][j] = anagramList.get(j);
				}	
				else if(number / 100 == 5)
				{
					arr[5][j] = anagramList.get(j);
				}
				else if(number / 100 == 6)
				{
					arr[6][j] = anagramList.get(j);
				}
				else if(number / 100 == 7)
				{
					arr[7][j] = anagramList.get(j);
				}
				else if(number / 100 == 8)
				{
					arr[8][j] = anagramList.get(j);
				}
				else if(number / 100 == 9)
				{
					arr[9][j] = anagramList.get(j);
				}
			}
			
		}
		int p = 0;
		for (int i = 0; i < 10; i++) 
		{
			if(p < 10)
			{
				if(p == 0)
					System.out.print ("0 to 100 \t: \t");
				else if(p == 1)
					System.out.print("100 to 200 \t: \t");
				else if(p == 2)
					System.out.print("200 to 300 \t: \t");
				else if(p == 3)
					System.out.print("300 to 400 \t: \t");
				else if(p == 4)
					System.out.print("400 to 500 \t: \t");
				else if(p == 5)
					System.out.print("500 to 600 \t: \t");
				else if(p == 6)
					System.out.print("600 to 700 \t: \t");
				else if(p == 7)
					System.out.print("700 to 800 \t: \t");
				else if(p == 8)
					System.out.print("800 to 900 \t: \t");
				else if(p == 9)
					System.out.print("900 to 1000 \t: \t");
				else
					System.out.print("Can't Print More Rows");
			}
			p++;
			
			//Printing all the Elements in the 2D array
			for (int j = 0; j < 79; j++) 
			{
				if(arr[i][j]!=0)
				System.out.print(arr[i][j] + " ");
					
			}
			System.out.println();
			
		}
	}

}
