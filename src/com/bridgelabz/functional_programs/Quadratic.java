package com.bridgelabz.functional_programs;
import com.bridgelabz.utility.Utility;

public class Quadratic 
{
	public static void main(String[] args) 
	{
		System.out.println("TO FIND ROOTS OF AN EQUATTION: ");
		System.out.println("Enter Value for 'a': ");
		double a = Utility.inputDouble();
		System.out.println("Enter Value for 'b': ");
		double b = Utility.inputDouble();
		System.out.println("Enter Value for 'c': ");
		double c = Utility.inputDouble();
		System.out.println("\nRoots Of the equation are: ");
		double delta =Math.abs( b*b-4*a*c);
		System.out.println(delta);
		double x = (-b-Math.sqrt(delta))/(2*a);
		double y = (-b+Math.sqrt(delta))/(2*a);
		System.out.println(x + " " + y);

	}

}
