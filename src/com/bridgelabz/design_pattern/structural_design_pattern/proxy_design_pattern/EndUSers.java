package com.bridgelabz.design_pattern.structural_design_pattern.proxy_design_pattern;
/**
 * @author Bikahs Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: Main Class
 */
import com.bridgelabz.utility.Utility;

public class EndUSers
{
	public static void main(String[] args) 
	{
		I_Internet_Interface internet = new BannedSites();
		BannedSites bannedList = new BannedSites();
		
		System.out.println("enter list All command to show all Banned Sites(ls-al): ");
		String command = Utility.inputString();
		
		try 
		{
			if(command.equals("ls-al"))
			{
				bannedList.display();
			}
		} 
		catch (Exception e1) 
		{
			System.out.println(e1.getMessage());
		}
		
		System.out.println("Search Sites: ");
		//Check The Site is banned or not. this method will go to BannedSite.java and check each site user input
		try 
		{
			internet.connect(Utility.inputString());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
