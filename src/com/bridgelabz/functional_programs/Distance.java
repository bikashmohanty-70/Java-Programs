package com.bridgelabz.functional_programs;

import com.bridgelabz.utility.InputUtility;

public class Distance 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Co-ordiantes of X and Y: ");
		
		//int x = Integer.parseInt(args[0]);
		//int y = Integer.parseInt(args[1]);
		
		double x = InputUtility.inputDouble();
		double y = InputUtility.inputDouble();
		
		double dist = Math.sqrt(x*x + y*y);
		System.out.println("Distance From "+x+" and "+y+" to origin (0, 0) is: "+dist);
	}

}
