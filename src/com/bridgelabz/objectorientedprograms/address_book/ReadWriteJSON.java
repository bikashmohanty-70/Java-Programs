package com.bridgelabz.address_book;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadWriteJSON 
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
			fileWriter.close();
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
			fileReader.close();
			return mainArrayObject;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
