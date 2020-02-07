package com.bridgelabz.objectorientedprograms;

/**
 * @author Bikash Mohanty
 * @since 29th Nov 2019
 * @Version 1.1
 * 
 * Purpose: JSON Inventory Data Management of Rice, Pulses and Wheats
 * 
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.utility.InputUtility;


public class InventoryManagementArrayOfObjects 
{
	@SuppressWarnings("unchecked")
	public static JSONObject detailedEntry()
	{
		JSONObject inventoryItems = new JSONObject();	
		while (true) 
		{
			System.out.print("Enter Name: ");
			String name = InputUtility.inputStringLine();
			
			if(name.length() == 0)
				break;
			
			System.out.print("Enter Weight: ");
			String weight = InputUtility.inputStringLine();
			
			System.out.print("Enter Price: ");
			double price = InputUtility.inputDouble();
			
			inventoryItems.put("Rice",name);
			inventoryItems.put("Weight",weight);
			inventoryItems.put("Price",price);
		}
		
		return inventoryItems;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		
		JSONArray arrayOfInventory = new JSONArray();

		
		System.out.println("-: Inventory Management :-");
		
		System.out.println("Enter Details of Rice");
		arrayOfInventory.add(detailedEntry());
		
		System.out.println("Eneter Details of Wheat:");
		arrayOfInventory.add(detailedEntry());
		
		System.out.println("Enter Details of Pulses");
		arrayOfInventory.add(detailedEntry());
		
		try(PrintWriter printToFile = new PrintWriter("C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\json\\inventory_details_array_of_objects.json"))
		{
			printToFile.write(arrayOfInventory.toJSONString());
			printToFile.flush();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

	}

}
