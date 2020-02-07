package com.bridgelabz.datastructure;


import com.bridgelabz.utility.Utility;

public class PrimeNumbers2D 
{

	public static void main(String[] args) 
	{
		int number = 1;
		int [][] arr = new int[10][100];
		for(int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 100; j++)
			{
				if(Utility.isPrime(number))
				{
					arr[i][j] = number;
				}
				else
					arr[i][j] = -1;
				number++;
			}
		}
		
		int p = 0;
		
		for(int[] k1 : arr)
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
			for(int k2 : k1)
			{
				if(k2 != -1 && k2 != 1)
					System.out.print(k2+" ");
			}
			System.out.println("\n");
		}
		
	}

}
