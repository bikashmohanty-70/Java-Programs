package com.bridgelabz.clinic_management;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadWriteJSONClinicManagement
{
	/**
	 * 
	 * @param filePath --> string
	 * @param mainArrayObject --> jsonObject
	 */
	public static void writeToFile(String filePath, JSONObject mainArrayObject)
	{
		try(FileWriter fileWriter = new FileWriter(filePath))
		{
			fileWriter.write(mainArrayObject.toJSONString());
			fileWriter.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param filePath --> Path of the file as String Type
	 * @return --> JSONObject
	 */
	public static JSONObject readFile(String filePath)
	{
		JSONObject mainArrayObject = new JSONObject();
		try(FileReader fileReader = new FileReader(filePath))
		{
			JSONParser parser = new JSONParser();
			mainArrayObject = (JSONObject) parser.parse(fileReader);
			return mainArrayObject;
		}
		catch(IOException | ParseException e)
		{
			System.out.println("ReadWriteFile Error: File is Empty... But Dont Worry...");
		}
		return null;
	}

}
