package com.bridgelabz.functional_programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.bridgelabz.utility.InputUtility;

public class ArrayTwoDUsingPrintWriter 
{

	public static void main(String[] args) throws IOException 
	{
		//System.out.print("Enter FIle NAme: ");
		//String fileName = InputUtility.inputString();
		File file = new File("C:/Users/Admin/Desktop/Bikash.txt");
		if(file.createNewFile())
			System.out.println("Successfully Created");
		else
			System.out.println("File Already Exists..");
		
		Two_D_Array(file);
	}

	private static void Two_D_Array(File file) throws FileNotFoundException 
	{
		PrintWriter printW = new PrintWriter(file);
		
		System.out.println("Let's make a Two D array and print it in a FIle..!!");
		System.out.print("\nHow Many number of rows do u want in Tow_D_Array: ");
		int rows = InputUtility.inputInteger();
		System.out.println("\nHow many columns do you want in Two_D_Array: ");
		int cols = InputUtility.inputInteger();
		
		int[][] array = new int[rows][cols];
		
		System.out.println("Enter Array Elements:");
		
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				array[i][j] = InputUtility.inputInteger();
			}
			System.out.println();
		}
		System.out.println("Printing Array to FIle...");
		printW.println("2D Array");
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				System.out.print(array[i][j] + " ");
				printW.print(array[i][j]+ " ");
			}
			System.out.println();
			printW.println();
		}
		printW.close();
		
	}

}
