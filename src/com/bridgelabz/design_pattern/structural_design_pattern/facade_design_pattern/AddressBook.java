package com.bridgelabz.design_pattern.structural_design_pattern.facade_design_pattern;
/**
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: To implement Facade Design Pattern using Database
 */
import java.sql.SQLException;

import com.bridgelabz.utility.InputUtility;

public class AddressBook 
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{		
		FacadeDatabse facadeDatabase = new FacadeDatabse();
		System.out.println("Enter Database Name : ");
		String datatbase = InputUtility.inputString();
		System.out.println("Enter Username");
		String username = InputUtility.inputString();
		System.out.println("Enter Password");
		String password = InputUtility.inputString();
		
		String query = null;
		
		do 
		{
			System.out.println("1. Insert Data\n2. Read Data\n");
			System.out.println("Enter your Choice");
			int choice = InputUtility.inputInteger();
			switch (choice) 
			{
			case 1:
				query = "create table Address_Book (`ID` INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT, `FIRST_NAME` VARCHAR(20), `LAST_NAME` VARCHAR(20), "
						+ "`ADDRESS` VARCHAR(20), `CITY` VARCHAR(15), `STATE` VARCHAR(15), `ZIP` INTEGER(6), `CONTACT` BIGINT(10));";
				System.out.println("Table Created Successfully...!!!");
				
				System.out.println("Enter First Name: ");
				String fname = InputUtility.inputString();
				System.out.println("Enter Last Name: ");
				String lname = InputUtility.inputString();
				System.out.println("Enter Address: ");
				String address = InputUtility.inputString();
				System.out.println("Enter City Name: ");
				String city = InputUtility.inputString();
				System.out.println("Enter State:");
				String state = InputUtility.inputString();
				System.out.println("Enter ZIP: ");
				int zip = InputUtility.inputInteger();
				System.out.println("Enter Contact no: ");
				long contact = InputUtility.inputLong();

				String sqlQuery1 = "INSERT INTO Address_Book(FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, ZIP, CONTACT) VALUES "
						+ "('"+fname+"', '"+lname+"', '"+address+"', '"+city+"', '"+state+"', '"+zip+"', '"+contact+"');";
				
				
				facadeDatabase.init("jdbc:mysql://localhost:3306/"+datatbase+"?autoReconnect=true&useSSL=false", username, password, query);
				facadeDatabase.insertToTable(sqlQuery1);
				
				System.out.println("Record Inserted");
				break;
				
			case 2:
				facadeDatabase.init("jdbc:mysql://localhost:3306/"+datatbase+"?autoReconnect=true&useSSL=false", username, password, query);
				facadeDatabase.readFromDataBase("SELECT * FROM Address_Book");
				break;

			default:
				System.out.println("invalid CHoice");
				break;
			}
		}while(true);		
		
	}

}
