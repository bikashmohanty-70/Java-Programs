package com.bridgelabz.datastructure;
import com.bridgelabz.utility.Dequeue;
import com.bridgelabz.utility.Utility;
/**
 * @Author   :  Bikash Mohanty
 * @Version  :  1.0
 * @Date     :  22nd  Nov, 2019
 * Purpose   :  A pallindrome is a string that reads the same forward and backward, for example:
  				radar, toot, and madam using Dequeue data type. We would like to construct an 
  				algorithm to input a string of characters and check whether it is a pallindrome.
 */



public class PallindromeChecker 
{	
	public static boolean checkPallindrome(String str2) 
	{
		Dequeue<Character> dequeue = new Dequeue<>();	// creating an object of Dequeue class

		for (int i = 0; i < str2.length(); i++) 
		{
			char ch = str2.charAt(i);
			dequeue.addFront(ch);
		}
		
		String reverse = "";
		
		for (int i = 0; i < str2.length(); i++)
		{
			reverse = reverse + dequeue.removeFront();
			
		}

		if (reverse.equals(str2)) 
			return true;
		else
			return false;
	}
	public static void main(String[] args) 
	{

		System.out.println("Enter a String : ");
		String str = Utility.inputStringLine();
		
		if(PallindromeChecker.checkPallindrome(str))
			System.out.println("Pallindrome");
		else
			System.out.println("Not Pallindrome");

	}
	
	
}
