package com.bridgelabz.design_pattern.structural_design_pattern.adapter_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: Socket class job is to instantiate instance of Volt class
 *
 */
public class Socket 
{

	public Volt getVolt()
	{
		return new Volt(240);
	}
}