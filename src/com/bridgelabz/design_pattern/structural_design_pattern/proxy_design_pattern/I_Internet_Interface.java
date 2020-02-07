package com.bridgelabz.design_pattern.structural_design_pattern.proxy_design_pattern;

import java.util.List;

/**
 * 
 * @author Bikash Mohanty
 * @since 11th Dec 2019
 * @version 1.0
 * 
 * Purpose : Interface
 *
 */
public interface I_Internet_Interface 
{
	public void connect(String sites) throws Exception;

	public void display(List<String> bannedSites);

}
