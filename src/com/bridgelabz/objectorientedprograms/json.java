package com.bridgelabz.objectorientedprograms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class json {
	private static final String PATH = "C:\\Users\\Admin\\eclipse-workspace\\BridgeLabz Programming Problems\\json\\Json.json";

	@SuppressWarnings({ "unchecked", "resource" })
	public static void readData() throws IOException {
		Scanner scanner = new Scanner(System.in);
		JSONArray array = new JSONArray();
		System.out.println("Enter the number");
		int number = scanner.nextInt();
		while (number != 0) {
			JSONObject obj = new JSONObject();
			obj.put("Name", scanner.next());
			obj.put("weight", scanner.nextInt());
			array.add(obj);
			number--;

			BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(PATH));
			bufferedReader.write(array.toJSONString());
			bufferedReader.flush();
		}
	}

	public static void main(String[] args) throws IOException {
		readData();
	}
}