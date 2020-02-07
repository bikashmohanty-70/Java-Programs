package com.bridgelabz.design_pattern.structural_design_pattern.adapter_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: This class uses Java Composition and adapter contains the source object.
 *
 */
public class SocketObjectAdapter implements ISocketAdapter
{
	private Socket socketObject = new Socket();

	@Override
	public Volt get120Volts() 
	{
		return socketObject.getVolt();
	}

	@Override
	public Volt get12Volts() 
	{
		Volt v= socketObject.getVolt();
		return convertVolt(v,10);
	}

	@Override
	public Volt get3Volts() 
	{
		Volt v= socketObject.getVolt();
		return convertVolt(v,40);
	}
	
	private Volt convertVolt(Volt v, int i) 
	{
		return new Volt(v.getVolts()/i);
	}
	
}
