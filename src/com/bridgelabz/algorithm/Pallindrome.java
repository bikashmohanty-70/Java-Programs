package com.bridgelabz.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utility.Utility;

public class Pallindrome 
{

	//public String list;
	public static List<Integer> list = new ArrayList<Integer>();

	public Pallindrome(int i) 
	{
		
		if(Utility.isPallindrome(i))
		{
			list.add(i);
		}
	}

	public static void main(String[] args) 
	{

	}

}
