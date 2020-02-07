package com.bridgelabz.address_book;

/**
 * @author Bikash Mohanty
 * @Version 1.0
 * @since 2nd Dec 2019
 * 
 * Purpose: it's the service implementation class of the AddressBook 
 */


import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.utility.Utility;

public class ServiceImplementation extends ReadWriteJSON implements IServiceInterface 
{
	Model addressModel = new Model();

	static String path = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\AddressBook.json";
	public String fileReading = Utility.readFromFile(path);
	public JSONParser parser = new JSONParser();

	JSONObject mainObject = new JSONObject();
	
	/**
	 * Creating Address Log for entering addresses
	 */
	@SuppressWarnings("unchecked")
	public void addAddress() 
	{
		mainObject = ReadWriteJSON.readFile(path); //Reading The file before Writing into it and initializing the returned object in JSONOBJECT

		JSONObject addAddressObject = new JSONObject();

		System.out.println("Enter First Name: ");
		addressModel.setFirstName(Utility.inputString());
		addAddressObject.put("First_Name", addressModel.getFirstName());

		System.out.println("Enter Last Name: ");
		addressModel.setLastName(Utility.inputString());
		addAddressObject.put("Last_Name", addressModel.getLastName());

		System.out.println("Enter Address: ");
		addressModel.setAddress(Utility.inputString());
		addAddressObject.put("Address", addressModel.getAddress());

		System.out.println("Enter City: ");
		addressModel.setCity(Utility.inputString());
		addAddressObject.put("City", addressModel.getCity());

		System.out.println("Enter State: ");
		addressModel.setState(Utility.inputString());
		addAddressObject.put("State", addressModel.getState());

		System.out.println("Enter Zip Code: ");
		addressModel.setZip(Utility.inputLong());
		addAddressObject.put("Zip", addressModel.getZip());

		System.out.println("Enter Contact Number: ");
		addressModel.setContactNo(Utility.inputLong());
		addAddressObject.put("Contact", addressModel.getContactNo());

		mainObject.put(addressModel.getFirstName(), addAddressObject); //Will Put the file object already present inside the JSONOBJECT with a KEy and new JSONOBJECT
		ReadWriteJSON.writeToFile(path, mainObject);	// Writing into JSONFile	

	}

	/**
	 * Reading JSONFile and Parsing the JSONString to  JSONObject
	 */
	@SuppressWarnings("unchecked")
	public void readFromJSON()
	{
		System.out.println("\n************************View Address of User:************************\n");

		JSONObject addressFileObject = null;
		//Iterating through ArrayObjects
		try 
		{
			String fileRead = Utility.readFromFile(path);
			addressFileObject = (JSONObject) parser.parse(fileRead);

			System.out.println("     Available Uers:");
			System.out.println("------------------------");
			Set<?> s =  addressFileObject.keySet(); 	//Using the keySet property to list each object's KEY

			Iterator<?> i = s.iterator();
			do{
				String k = i.next().toString();
				System.out.println("\t"+k);

			}while(i.hasNext());
			System.out.println("------------------------");

			System.out.println();
			System.out.print("Whose Address You Wanna See:");
			String firstName = Utility.inputString();

			JSONArray arrayItems = new JSONArray();
			arrayItems.add(addressFileObject.get(firstName));
			Iterator<?> iterator = arrayItems.iterator();

			System.out.println("\n["+firstName+"'s Address]\n");
			while (iterator.hasNext()) //Iterating thorugh JSONObjectso
			{
				JSONObject jsonObject = (JSONObject) iterator.next();
				String fname = (String) jsonObject.get("First_Name");
				String lname = (String) jsonObject.get("Last_Name");
				String address = (String) jsonObject.get("Address");
				String city = (String) jsonObject.get("City");
				String state = (String) jsonObject.get("State");
				long zip = (long) jsonObject.get("Zip");
				long contact = (long) jsonObject.get("Contact");

				System.out.println("Name: " + (fname+" "+lname));
				System.out.println("Address: " + address + "\nCity: " + city + "\nState : " + state);
				System.out.println("Contact: " + contact);
				System.out.println("Zip: " + zip);
				System.out.println();
			}
			System.out.println("_____________________________________");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	//Update Address
	@SuppressWarnings("unchecked")
	public void updateAddress() 
	{
		@SuppressWarnings("unused")
		JSONObject updatedObject = new JSONObject();

		try 
		{
			JSONObject updateAddressObject = (JSONObject) parser.parse(fileReading);
			Set<?> s =  updateAddressObject.keySet();

			System.out.println("Available Records: \n_______________________________\n");
			Iterator<?> i = s.iterator();
			do{
				String k = i.next().toString();
				System.out.println(k);

			}while(i.hasNext());

			System.out.println("_______________________________\n");
			System.out.println("Whose Address You wanna Change?");

			String personName = Utility.inputString();
			JSONObject getObjectByKey = (JSONObject) updateAddressObject.get(personName);

			System.out.println("\n****************Update Address**************\n");

			System.out.println("Enter Address: ");
			addressModel.setAddress(Utility.inputString());
			getObjectByKey.put("Address", addressModel.getAddress());

			System.out.println("Enter City: ");
			addressModel.setCity(Utility.inputString());
			getObjectByKey.put("City", addressModel.getCity());

			System.out.println("Enter State: ");
			addressModel.setState(Utility.inputString());
			getObjectByKey.put("State", addressModel.getState());

			System.out.println("Enter Zip Code: ");
			addressModel.setZip(Utility.inputLong());
			getObjectByKey.put("Zip", addressModel.getZip());

			System.out.println("Enter Contact Number: ");
			addressModel.setContactNo(Utility.inputLong());
			getObjectByKey.put("Contact", addressModel.getContactNo());

			System.out.println(updateAddressObject.toJSONString());
			System.out.println("Updated SuccessFully...");

			ReadWriteJSON.writeToFile(path, updateAddressObject);

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

	//Remove Address

	public void removeAddress() 
	{
		JSONObject removeJSONObject;
		try 
		{
			removeJSONObject = (JSONObject) parser.parse(fileReading);

			Set<?> setOfKeys =  removeJSONObject.keySet();

			System.out.println("Available Records: \n_______________________________\n");
			Iterator<?> i = setOfKeys.iterator();
			do{
				String k = i.next().toString();
				System.out.println(k);

			}while(i.hasNext());

			System.out.println("Whose Address Do You Want Remove: ");
			String personName = Utility.inputString();

			removeJSONObject.remove(personName);
			System.out.println(removeJSONObject.toJSONString());
			ReadWriteJSON.writeToFile(path, removeJSONObject);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
