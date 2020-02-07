package com.bridgelabz.design_pattern.prototype_pattern;

/**
 * @Author : Bikash Mohanty
 * @version : 1.0
 * @since : 8th Dec 2019
 * 
 * Purpose : Prototype design pattern program 
 */
import java.util.List;

import com.bridgelabz.utility.InputUtility;

public class Controller {

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		Employees employees = new Employees();
		employees.loadData();

		Employees empsNew = (Employees) employees.clone();
		Employees empsNew1 = (Employees) employees.clone();

		List<String> list = empsNew.getEmpList();

		System.out.println("Enter the choice ");
		System.out.println("1. Add Data");
		System.out.println("2. Remove");
		System.out.println("3. Exit");

		int choice = InputUtility.inputInteger();
		System.out.println("How many Data you have");
		int number = InputUtility.inputInteger();
		List<String> list1 = empsNew1.getEmpList();

		while (number != 0) 
		{
			switch (choice) 
			{
			case 1:
				System.out.println("Enter Name of the Employee to add ");
				list.add(InputUtility.inputString());
				number--;
				break;

			case 2:
				System.out.println("Enter Name of the Employee to remove");
				list.remove(InputUtility.inputString());
				number--;
				break;

			case 3:
				System.out.println("ThankYou!!!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid");
				break;
			}
		}
		System.out.println("emps List: " + employees.getEmpList());
		System.out.println("empsNew List: " + list);
		System.out.println("empsNew1 List: " + list1);
	}
}
