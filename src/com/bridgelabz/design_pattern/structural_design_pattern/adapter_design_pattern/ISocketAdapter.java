package com.bridgelabz.design_pattern.structural_design_pattern.adapter_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: SocketAdapter interface is going to be implemented for different classes
 *
 */
public interface ISocketAdapter 
{
	public Volt get120Volts();
	public Volt get12Volts();
	public Volt get3Volts();
}
