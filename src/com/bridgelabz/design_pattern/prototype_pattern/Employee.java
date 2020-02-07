package com.bridgelabz.design_pattern.prototype_pattern;
/**
 * @Author : Bikash MOhanty
 * @Version : 1.0
 * @since : 8th Dec 2019
 */
public class Employee 
{
	private String name;
	private String newName;

	@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", newName=" + newName + "]";
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getNewName() 
	{
		return newName;
	}

	public void setNewName(String newName) 
	{
		this.newName = newName;
	}

}
