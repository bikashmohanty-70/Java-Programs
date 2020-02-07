package com.bridgelabz.design_pattern.factory_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 *
 */
import com.bridgelabz.utility.Utility;

public class ParentFactory 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter Type (PC/Server): ");
		String type = Utility.inputString();
		System.out.println("ENter Ram: ");
		String ram = Utility.inputString();
		System.out.println("Hard Disk: ");
		String hdd = Utility.inputString();
		System.out.println("CPU: ");
		String cpu = Utility.inputString();
		
		Computers pc = ComputerFactory.getComputers(type,ram,hdd,cpu);
		Computers server = ComputerFactory.getComputers(type,ram,hdd,cpu);
		System.out.println("Factory PC Config::"+pc);
		System.out.println("Factory Server Config::"+server);
	}
}
