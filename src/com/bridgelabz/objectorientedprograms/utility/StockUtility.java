package com.bridgelabz.utility;

/**
 *
 *  @author  Bikash Mohanty
 *  @version 1.0
 *  @since   20-11-2019
 *  
 *  Purpose: Stock Account Management Problem
 *
 */
import java.util.Random;
import java.util.Scanner;

public class StockUtility 
{
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();

	public static int inputIntegerOne() 
	{
		try {

			return Integer.parseInt(scanner.nextLine());

		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}

	public static int inputInteger()
	{
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Invalied Input");
		}
		return 0;
	}

	public static boolean checkStringOne(String userInput) 
	{

		char ch[] = userInput.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				return false;
			}
		}
		return true;
	}

	public static double inputDouble() 
	{
		try {
			if (scanner.hasNextDouble()) 
			{
				return scanner.nextDouble();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Invalied Input");
		}
		return 0.0;
	}

	public static long inputLong() 
	{
		try 
		{
			return scanner.nextLong();
		}
		catch (Exception e) 
		{
			System.out.println("Invalied Input");
		}
		return 0;
	}

	public static String inputString() 
	{
		try 
		{
			return scanner.next();
		} 
		catch (Exception e) 
		{
			System.out.println("Invalied Input");
		}
		return null;
	}

	public static String inputStringLine()
	{
		try 
		{
			return scanner.nextLine();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return null;
	}

	public static float inputFloat() 
	{
		try 
		{
			return scanner.nextFloat();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return 0L;
	}

	public static boolean inputBoolean() 
	{
		try 
		{
			return scanner.nextBoolean();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	public static boolean checkNumber(long currentAmount) 
	{
		if (currentAmount >= 'A' && currentAmount <= 'Z' || currentAmount == 'a' && currentAmount == 'z') 
		{
			return false;
		}
		while (currentAmount != 0) 
		{
			long rem = currentAmount % 10;
			currentAmount = currentAmount / 10;
			if (rem == 0 || rem == 1 || rem == 2 || rem == 3 || rem == 4 || rem == 5 || rem == 6 || rem == 7 || rem == 8
					|| rem == 9)
				return true;
		}
		return false;
	}

	public static boolean checkString(String string) 
	{
		char charcter[] = string.toCharArray();
		for (int i = 0; i < charcter.length; i++) {
			if (charcter[i] >= 'A' && charcter[i] <= 'Z' || charcter[i] == 'a' && charcter[i] == 'z') 
			{
				return true;
			}
		}
		return false;
	}

}
