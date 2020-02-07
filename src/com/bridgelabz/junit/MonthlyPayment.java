package com.bridgelabz.junit;

public class MonthlyPayment {

	public static void main(String[] args) 
	{
		float principal_amount = Float.parseFloat(args[0]);
		float rateOf_Interest = Float.parseFloat(args[1]);
		float total_years = Float.parseFloat(args[2]);
		
		checkPayment(principal_amount, rateOf_Interest, total_years);
		
	}

	private static void checkPayment(float principal_amount, float rateOf_Interest, float total_years) 
	{
		float payment = 0;
		float interest = 0;
		if(principal_amount > 0)
		{
			float n = 12 * total_years;
			float r = rateOf_Interest/(12*100);
			payment = (float) ((principal_amount*r) / (1 - Math.pow((1+r),-n)));
			interest = (payment * n) - principal_amount;
		}
		
		System.out.println("Regular Payment: "+payment);
		System.out.println("Total interest paid for amortizing payments: "+interest);
	}

}
