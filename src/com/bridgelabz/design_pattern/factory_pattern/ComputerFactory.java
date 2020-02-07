package com.bridgelabz.design_pattern.factory_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 *
 */
public class ComputerFactory 
{
	public static Computers getComputers(String type, String hdd, String ram, String cpu)
	{
		if("PC".equalsIgnoreCase(type)) 
			return new PC(ram, hdd, cpu);
		else if("Server".equalsIgnoreCase(type)) 
			return new Server(ram, hdd, cpu);
		
		return null;
		
	}
}
