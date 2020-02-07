package com.bridgelabz.design_pattern.prototype_pattern;
/**
 * @Author : Bikash MOhanty
 * @Version : 1.0
 * @since : 8th Dec 2019
 */
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.utility.InputUtility;

public class Employees implements Cloneable 
{

	private List<String> employeeList = null;

	public Employees() 
	{
		employeeList = new ArrayList<String>();
	}

	public Employees(List<String> list) 
	{
		this.employeeList = list;
	}


	 //Function to load data of employee
	 
	public void loadData() 
	{
		System.out.println("How many data you have");
		int number = InputUtility.inputInteger();
		while (number != 0) 
		{
			System.out.println("Enter Name of the Employee");
			employeeList.add(InputUtility.inputString());
			number--;
		}
	}

	public List<String> getEmpList() 
	{
		return employeeList;
	}

	@Override
	public Object clone() throws CloneNotSupportedException 
	{
		List<String> temp = new ArrayList<>();
		for (String string : this.getEmpList()) 
		{
			temp.add(string);
		}
		return new Employees(temp);
	}

}
