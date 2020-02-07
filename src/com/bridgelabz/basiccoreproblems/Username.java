package com.bridgelabz.basiccoreproblems;

import com.bridgelabz.utility.Utility;

/**
 * 
 * @author Bikash Mohanty
 * @version 1.0
 * @since 12th Nov, 2019
 *
 * Purpose: To check whether the User name Entered has at least 3 Characters or not
 *			if yes, it will replace the User Name from "Hello <<UserName>>, How are You?" 
 *			with the UserName Provided by the user.
 */
public class Username 
{
	public static void main(String[] args) 
	{
		String userName = null; //Initializing userName to null
		System.out.println("Hello <<Username>>, How Are You?\n");
		boolean check = false; //To run the loop until 'check' become true
		while(!check) //When check become true loop exits
		{
			System.out.println("Eneter Username (Must have 3 characters): ");
			userName = Utility.inputString(); // Calling inputString() from Utility class
			
			/**
			 * if entered string doesn't have 3 characters in it then it will ask user to
			 * Enter UserName again
			 * else it will print the UserName entered in place of <<UserName>>
			 */
			
			if(Utility.stringCheck(userName)) //@param used to pass the string value to stringCheck() in Utility class
			{
				System.out.println("Hello "+userName+ ", How Are You?");
				check = true;
			}
			else
			{
				System.out.println("UserName Must Have 3 Characters at least");
			}
		}
		
		
		
		
		

	}

}
