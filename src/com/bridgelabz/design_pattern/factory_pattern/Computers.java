package com.bridgelabz.design_pattern.factory_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 7th Dec 2019
 * @version 1.0
 *
 */
public abstract class Computers 
{
	public abstract String getHDD();
	public abstract String geRAM();
	public abstract String getCPU();
	
	public String toString()
	{
		return "CPU : "+this.getCPU()+"\nHDD : "+this.getHDD()+"\nRAM : "+this.geRAM();
	}

}
