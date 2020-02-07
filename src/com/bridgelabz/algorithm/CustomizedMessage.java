package com.bridgelabz.algorithm;

import com.bridgelabz.utility.InputUtility;

public class CustomizedMessage 
{
	
	public static void main(String[] args) 
	{
		System.out.println("Hello Bikash, We've your Full Name as Bikash Mohanty in our System."
				+ "Your Contact Number is 91-9438626164. "
				+ "Please, let us know in case of any clarification Thank you BridgeLabz 01/01/2016. ");
	
		
		System.out.println();
		System.out.println("ENter First Name");
		String fname = InputUtility.inputString();
		System.out.println("Enter Last Name: ");
		String lname = InputUtility.inputString();
		System.out.println("Enter Your Phone Number");
		String number = InputUtility.inputString();
		
		check(fname, lname, number);
	}

	private static void check(String fname, String lname, String num) 
	{
		if ((fname != null && lname != null) && (fname.matches("^[a-zA-Z]*$") && lname.matches("^[a-zA-Z]*$")))
		{
			System.out.println("Hello " +fname+", We've your Full Name as " +fname +" "+lname + " in our System.");

		}
		if(num.matches("\\d{10}"))
		{
			System.out.println("Your Contact Number is " +num + "\n\"Please, let us know in case of any clarification Thank you BridgeLabz 01/01/2016. \"");
		}
		else
		{
			System.out.println("Number Didn't MAtch to the criteria");
		}
		
	}

}
