package com.bridgelabz.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BinarySearchTrialTest 
{

	public static void main(String[] args)
	{
		/*
		 * int arr[] = { 2, 3, 4, 10, 40 }; int n = arr.length; int x = 10;
		 */
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter List VAlues: ");
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while(i <= 5)
		{
			list.add(sc.nextInt());
			i++;
		}
		Collections.sort(list);
		System.out.print("After SOrting: " +list);
		int n = list.size();
		System.out.println("Enter Value TO Search: ");
		int x = sc.nextInt();
        int result = Utility.binarySearch(list, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result);
        
        sc.close();
	}

}
