package com.bridgelabz.objectorientedprograms;

/**
 * @author Bikash Mohanty
 * @since 29th Nov 2019
 * @Version 1.2
 * 
 * Purpose: JSON Inventory Data Management of Rice, Pulses and Wheats
 * 
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.utility.InputUtility;
import com.bridgelabz.utility.Utility;

public class inventoryManagementObjectsOfObjects {
	/**
	 * 
	 * @return --> JSONObject type
	 * 
	 *         This Method basically takes the input from User and Store them in an
	 *         JSONObject
	 */

	@SuppressWarnings("unchecked")
	public static JSONObject detailedEntry() {
		JSONObject inventoryItems = new JSONObject();

		System.out.print("Enter Name: ");
		String name = InputUtility.inputString();

		System.out.print("Enter Weight: ");
		double weight = InputUtility.inputDouble();

		System.out.print("Enter Price: ");
		double price = InputUtility.inputDouble();

		inventoryItems.put("Name", name);
		inventoryItems.put("Weight(KG)", weight);
		inventoryItems.put("Price", price);

		return inventoryItems;
	}

	private static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\json\\objectsOfObjects.json";

	// Main Method
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JSONObject rootObject = new JSONObject(); // Main JSONObject

		System.out.println("-: Inventory Management :-");

		System.out.println("Enter Details of Rice");
		rootObject.put("Rice", detailedEntry());
		System.out.println("Entry Successful\n");

		System.out.println("Eneter Details of Wheat:");
		rootObject.put("Wheat", detailedEntry());
		System.out.println("Entry Successful\n");

		System.out.println("Enter Details of Pulses");
		rootObject.put("Pulses", detailedEntry());
		System.out.println("Entry Successful\n");

		/**
		 * Creating JSON File to store the output
		 */
		JSONObject rootDefault = new JSONObject();
		rootDefault = (JSONObject) rootObject.get("Wheat");
		rootDefault.remove("Name");
		System.out.println("Tracking rootDefault " + rootDefault.toJSONString());
		System.out.println("Tracking rootDefault " + rootObject.toJSONString());

		try (PrintWriter printToFile = new PrintWriter(PATH)) {
			printToFile.write(rootObject.toJSONString());
			System.out.println("\nRecord Successfully Saved...!!");
			printToFile.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String readFromFile = Utility.readFromFile(PATH);
		System.out.println(readFromFile);
		JSONParser jsonParser = new JSONParser();

		try {
			JSONObject objectFromFile = (JSONObject) jsonParser.parse(readFromFile);
			System.out.println();
			System.out.printf("Rice DEtails %s", objectFromFile.get("Rice"));

//			JSONObject riceObject = new JSONObject();
//			riceObject.put("Rice", objectFromFile.get("Rice"));
//			System.out.println(riceObject.get(1));
//			System.out.println(riceObject.toJSONString());

			JSONObject jsonOB = (JSONObject) objectFromFile.get("Rice");
			System.out.println("\nNEW JSONOBJECT: " + jsonOB);
			double lat = (double) jsonOB.get("Price");
			System.out.println(lat);

			System.out.println();
			System.out.printf("Wheat DEtails %s", objectFromFile.get("Wheat"));
			System.out.println();
			System.out.printf("Pulse DEtails %s", objectFromFile.get("Pulses"));

			System.out.println("\nAdding Values");
			System.out.println(objectFromFile.get("Wheat"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
