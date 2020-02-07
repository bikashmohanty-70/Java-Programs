package com.bridgelabz.design_pattern.structural_design_pattern.adapter_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: Adapter Design Pattern Test class
 *
 */

public class TestAdapterDesignPattern 
{

	public static void main(String[] args) 
	{
		//Creating object of SocketClassAdapter 
		ISocketAdapter adapterSocketInterface1 = new SocketClassAdapter();
		System.out.println("\n----------------------------------------------");
		System.out.println("Adapter Design Pattern Using Class Adapter\n----------------------------------------------");
		Volt v3 = getVolts(adapterSocketInterface1, 3);
		Volt v12 = getVolts(adapterSocketInterface1, 12);
		Volt v120 = getVolts(adapterSocketInterface1, 120);
		System.out.println("Socket Class Adapter v3 : "+v3.getVolts());
		System.out.println("Socket Class Adapter v12 : "+v12.getVolts());
		System.out.println("Socket Class Adapter v120 : "+v120.getVolts());
		
		//Creating object of SocketObjectAdapter
		System.out.println("\n----------------------------------------------");
		ISocketAdapter adapterSocketInterface2 = new SocketObjectAdapter();
		System.out.println("Adapter Design Pattern Using Object Adapter\n----------------------------------------------");
		Volt v_3 = getVolts(adapterSocketInterface2, 3);
		Volt v_12 = getVolts(adapterSocketInterface2, 12);
		Volt v_120 = getVolts(adapterSocketInterface2, 120);
		System.out.println("Socket Object Adapter v3 : "+v_3.getVolts());
		System.out.println("Socket Object Adapter v12 : "+v_12.getVolts());
		System.out.println("Socket Object Adapter v120 : "+v_120.getVolts());

	}

	private static Volt getVolts(ISocketAdapter adapterSocketInterface, int i) 
	{
		switch (i) 
		{
			case 120:
				return adapterSocketInterface.get120Volts();
			case 12:
				return adapterSocketInterface.get12Volts();
			case 3:
				return adapterSocketInterface.get3Volts();
		default:
			break;
		}
		return null;
	}

}
