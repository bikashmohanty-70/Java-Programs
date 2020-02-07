package com.bridgelabz.design_pattern.factory_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 *
 */
public class Server extends Computers
{
	private String ram;
	private String hdd;
	private String cpu;

	public Server(String ram, String hdd, String cpu)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}

	public String getHDD() 
	{

		return this.hdd;
	}

	public String geRAM() 
	{

		return this.ram;
	}

	public String getCPU() 
	{

		return this.cpu;
	}

}
