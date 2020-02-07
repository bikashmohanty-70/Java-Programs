package com.bridgelabz.junit;
/**
 * @author Bikash Mohanty
 * @version 1.0
 * @Created : 21st Nov, 2019
 * 
 * Purpose: TO convert celcius to fahrenheit and vice versa
 */
import java.util.Scanner;

public class TemperatureConversion 
{

	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
		System.out.println("which temperature you want to convert (Celcius(c) or Fahreheit(f): ");
		switch (sn.next().charAt(0)) 
		{
		case 'c':
			System.out.println("Enter Temperature in Fahrenheit to Convert it into Celcius: ");
			float f = sn.nextFloat();
			System.out.println("Fahrenheit --> Celcius : "+((f-32)*5/9));
			break;
			
		case 'f':
			System.out.println("Enter Temperature in Celcius to Convert it into Fahrenheit: ");
			float c = sn.nextFloat();
			System.out.println("Celcius --> Fahrenheit : "+((c * 9/5)+32));
			break;
			
		default:
			System.out.println("Invalid Input. Enter c or f");
			break;
		}
	}

}
