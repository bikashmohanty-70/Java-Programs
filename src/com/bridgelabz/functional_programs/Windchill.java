package com.bridgelabz.functional_programs;

public class Windchill 
{

	public static void main(String[] args) 
	{
		double t = Double.parseDouble(args[0]);
		double v = Double.parseDouble(args[1]);
		double w = 3574 + 0.621 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
	
		System.out.println("Temperature : "+t);
		System.out.println("Wind Speed: " +v);
		System.out.println("Wind CHill: "+w);
	}

}
