package com.bridgelabz.inventorymanagement;

/**
 *@Author   :  Bikash Mohanty
 *@Version  :  1.0
 *@Date     :  2019/11/30
 *Purpose   :  To create a JSON file having Inventory Details for Rice, Pulses 
 			   and Wheats with properties name, weight, price per kg.
 */

import java.io.FileWriter;

import org.json.simple.JSONObject;

import com.bridgelabz.utility.InputUtility;

public class Controller
{ 
	public static JSONObject jsonObject = new JSONObject();
	private static final String INVENTORY_FILE = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\Inventory.json";
	
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) 
	{
		IService inventoryServices = new ServicesImplementation();

		// creating a JSON object
		
		int ch = 0;
		do {
			System.out.println("*************************Inventory Data*************************");
			System.out.println("1. Add Details");
			System.out.println("2. View Deatils");
			System.out.println("3. Total Weight of Products in Inventory");
			System.out.println("4. Price(per kg)");
			System.out.println("5. Total Price of Products in Inventory");

			System.out.println("6. exit");

			int choice = InputUtility.inputInteger();
			switch (choice) {
			case 1: // logic to add details in inventory data
				System.out.println("Enter a details of Rice");
				jsonObject.put("Rice", inventoryServices.addDetails());

				System.out.println("Enter a details of Pulses");
				jsonObject.put("Pulses", inventoryServices.addDetails());

				System.out.println("Enter a details of Wheats");
				jsonObject.put("Wheats", inventoryServices.addDetails());
				
				try(FileWriter fileWriter = new FileWriter(INVENTORY_FILE)) 
				{
					fileWriter.write(jsonObject.toString());
					fileWriter.flush();
				} 
				catch (Exception e) 
				{
					System.out.println(e.getStackTrace());
				}
				break;

			// for reading the inventory data
			case 2:
				inventoryServices.readFile();
				break;

			// for calculating the total weight of items
			case 3:
				System.out.println("Total Weight of Rice,Pulses and Wheats : " + inventoryServices.totalWeight());
				break;

			// for calculating the individual price of rice,wheat and pulses
			case 4:
				System.out.println("Enter the item name : ");
				String item = InputUtility.inputString();
				System.out.println(item + " is " + inventoryServices.price(item) + " Rs per kg.");
				break;

			// for calculating the total price of items
			case 5:
				System.out.println("Total Price of Rice,Pulses and Wheats : " + inventoryServices.totalPrice());
				break;
				
			case 7:
				System.out.println("Thank You");
				System.exit(0);

			default:
				System.out.println("You entered wrong choice");
				break;
			}

		} while (ch < 6);
	}

}

