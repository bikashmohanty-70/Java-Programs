package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class ReversedPrimeAnagramsNumbersUsingQueue 
{

	public static void main(String[] args) 
	{
		Queue<Integer> queue = new Queue<>();
		// logic to push the prime number into stack
		for (int i = 2; i <= 1000; i++) 
		{
			if (Utility.isPrime(i)) 
			{
				queue.enQueue(i);
			}
		}

		// logic to store prime numbers from stack to array
		int size = queue.getSize();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) 
		{
			array[i] = queue.deQueue();
		}

		// logic to check prime numbers are anagram or not
//		System.out.println("Anagrams \t Primes");
		for (int i = 0; i < size; i++) 
		{
			for (int j = i + 1; j < size; j++) 
			{
				if (Utility.isAnagram(array[i], array[j]) && array[i] != 0 && array[j] != 0) 
				{
					//System.out.println(array[i] + " \t\t " + array[j]);
					queue.enQueue(array[i]);
					queue.enQueue(array[j]);
				}
			}
		}
		System.out.println("Anagrams From Queue: ");
		queue.display();
	}

}
