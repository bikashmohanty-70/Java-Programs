package com.bridgelabz.design_pattern.structural_design_pattern.proxy_design_pattern;
/**
 * @author Bikash  MOhanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose: Keeps the object of Banned sites safe.
 */
import java.util.ArrayList;
import java.util.List;

public class BannedSites implements I_Internet_Interface
{
	I_Internet_Interface internet = new PublicInternet();
	private static List<String> bannedSites;
	
	static
	{
		bannedSites = new ArrayList<>();
		bannedSites.add("torrentz.eu");
		bannedSites.add("kickass.io");
		bannedSites.add("sitebills.info");
		bannedSites.add("abc.xyz");
	}

	@Override
	public void connect(String sites) throws Exception 
	{
		if (bannedSites.contains(sites.toLowerCase()))
		{
			throw new Exception("Acces Deined..."+sites+" is banned");
		}
		internet.connect(sites);
	}

	public void display()
	{
		internet.display(bannedSites);
	}

	@Override
	public void display(List<String> bannedSites) 
	{		
	}
	
}
