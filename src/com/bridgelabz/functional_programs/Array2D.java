package com.bridgelabz.functional_programs;

import com.bridgelabz.utility.InputUtility;

/**
 * @author Bikash Mohanty
 * @version 1.0
 * @since: 13th Nov, 2019
 * 
 * purpose: This program takes the number of rows and number of columns as input and pass the array values
 * with number of row n columns to the Utility class to print 'row X columns' 2D Array 
 */

import com.bridgelabz.utility.Utility;

public class Array2D 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Number of Rows: ");
		int rows = InputUtility.inputInteger();
		System.out.println("Enter NUmber of Columns: ");
		int cols = InputUtility.inputInteger();
		int [][] array = new int [rows][cols];
		System.out.print("Enter Array Elemets for 2D Array: ");
		for (int i = 0; i < rows; i++) //'i' for rows
		{
			for (int j = 0; j < cols; j++) // 'j' is for columns
			{
				array[i][j] = InputUtility.inputInteger();	//Storing user input in a TwoDimensional Array	
			}
			
		}
		
		System.out.println("2D Array of "+rows+" X "+cols+ ": ");
		Utility.arrayTwoDimensional(array, rows, cols); //Calling the arrayTwoDimensional method from Utility class

	}

}
