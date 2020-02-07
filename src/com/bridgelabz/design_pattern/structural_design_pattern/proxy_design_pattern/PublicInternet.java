package com.bridgelabz.design_pattern.structural_design_pattern.proxy_design_pattern;
/**
 * @author Bikahs Mohanty
 * @since 11th DEc 2019
 * @VERSION 1.0
 * 
 * Purpose: Implementation class
 */
import java.util.List;

public class PublicInternet implements I_Internet_Interface
{

	@Override
	public void connect(String sites) 
	{
		System.out.println("COnnecting to: "+sites);		
	}

	@Override
	public void display(List<String> bannedSites) 
	{
		System.out.println(bannedSites);
		
	}

}
