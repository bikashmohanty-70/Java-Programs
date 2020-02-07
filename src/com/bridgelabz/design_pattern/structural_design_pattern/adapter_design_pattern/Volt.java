package com.bridgelabz.design_pattern.structural_design_pattern.adapter_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: Volt class
 *
 */
public class Volt 
{
	private int volts;

	public int getVolts() 
	{
		return volts;
	}

	public void setVolts(int volts) 
	{
		this.volts = volts;
	}
	
	//constructor
	public Volt(int v)
	{
		this.volts = v; 
	}

}
