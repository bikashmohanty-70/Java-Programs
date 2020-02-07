package com.bridgelabz.objectorientedprograms;

/**
 * @author Bikash Mohanty
 * @since 29th Nov 2019
 * @Version 1.0
 * 
 * Purpose: JSON Inventory Data Management of Rice, Pulses and Wheats
 * 
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Bikash Mohanty
 * @version 1.0
 * @since 29th Nov 2019
 * 
 * Purpose:  JSON Inventory Data Management of Rice, Pulses and Wheats 
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgelabz.utility.InputUtility;

public class InventoryManagement {
	@SuppressWarnings("unchecked")
	public static JSONArray detailedEntry() {
		// JSONObject inventoryItems = new JSONObject();
		JSONArray arrayOfInventory = new JSONArray();
		while (true) {
			System.out.print("Enter Name: ");
			String name = InputUtility.inputStringLine();
			System.out.println();

			if (name.length() == 0)
				break;

			System.out.print("Enter Weight: ");
			String weight = InputUtility.inputStringLine();
			System.out.println();

			System.out.print("Enter Price: ");
			double price = InputUtility.inputDouble();
			System.out.println();

			arrayOfInventory.add(name);
			arrayOfInventory.add(weight);
			arrayOfInventory.add(price);
		}

		return arrayOfInventory;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		JSONObject inventoryManagement = new JSONObject(); // Root JSON Object

		// JSONArray arrayOfInventory = new JSONArray();

		// JSONObject tempObject = new JSONObject();

		System.out.println("-: Inventory Management :-");

		System.out.println("Enter Details of Rice");
		// arrayOfInventory.add(detailedEntry());
		inventoryManagement.put("Rice", detailedEntry());

		System.out.println("Eneter Details of Wheat:");
		// arrayOfInventory.add(detailedEntry());
		inventoryManagement.put("Wheat", detailedEntry());

		System.out.println("Enter Details of Pulses");
		// arrayOfInventory.add(detailedEntry());
		inventoryManagement.put("Pulses", detailedEntry());

		try (PrintWriter printToFile = new PrintWriter(
				"C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\json\\inventory_details.json")) {
			printToFile.write(inventoryManagement.toJSONString());
			printToFile.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
