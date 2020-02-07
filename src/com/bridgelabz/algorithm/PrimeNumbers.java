package com.bridgelabz.algorithm;

/**
 * @author Bikash Mohanty
 * @since 15th Nov 2019
 * Purpose: 
 */

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utility.InputUtility;
import com.bridgelabz.utility.Utility;

public class PrimeNumbers 
{
	public PrimeNumbers(int num)
	{
		int i; 
		int j;
		
		List<Integer> list = new ArrayList<>();
		List<String> primeList = new ArrayList<>(), anagramList = new ArrayList<>();

		for (i = 2; i < num; i++)		//start from 2 -- one is not prime
		{        
			for (j = 2; j < i; j++)	//check for nontrivial divisors
			{      
				if (i % j == 0) 	//nontrivial divisor found -> not a prime
					break;          
			}
			if (j == i)            //this means the cycle above run till end
			{					 //hence no nontrivial divisors, hence a prime
				System.out.println(i);
				
				primeList.add(Integer.toString(i));
				
				/**
				 * if The Number is Prime then it will check whether its a Palindrome or not
				 * if the prime number is a palindrome then it'll add all the palindrome numbers in a List.
				 */
				
				if(Utility.isPallindrome(i)) 
					list.add(i);
			}
		}
		System.out.println();
		System.out.println("Prime Numbers List: "+primeList);
		System.out.println("Prime Pallimdromes are: "+list);
		
		for (int k = 0; k < primeList.size(); k++) 
		{
			for (int k2 = k+1; k2 < primeList.size(); k2++) 
			{
				if (Utility.isAnagram(primeList.get(k), primeList.get(k2))) 
				{
					anagramList.add(primeList.get(k));
					//System.out.println(primeList.get(k)+ " and "+primeList.get(k2)+ " are Anagram");
				}
			}
		}
		System.out.println("Prime Anagrams Are: "+anagramList);
	}

	public static void main(String[] args) 
	{
		System.out.println("Enter Range: ");
		int num = InputUtility.inputInteger();
		
		@SuppressWarnings("unused")
		PrimeNumbers prime = new PrimeNumbers(num);
	}
}

