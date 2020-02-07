package com.bridgelabz.design_pattern.structural_design_pattern.facade_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: This class Provide a unified interface to a set of interfaces in a subsystem.
 * 			The set interfaces are defined in ConnectDatabase.
 *
 */
import java.sql.SQLException;

public class FacadeDatabse 
{
	private ConnectDatabase database_connection;
	//Connecting to Database
	public FacadeDatabse() throws ClassNotFoundException
	{
		database_connection = new ConnectDatabase();
	}
	//initializing all the basic functions that're required to connect with MySQL
	public void init(String url, String username, String password, String query) throws SQLException
	{
		database_connection.createConnection(url, username, password);
		database_connection.createStatement();
		database_connection.createTable(query);
	}
	//Function to insert data into Database Table
	public int insertToTable(String sqlQuery) throws SQLException
	{
		return database_connection.insertIntoTable(sqlQuery);
	}
	//Function to read data from Database
	public void readFromDataBase(String query)
	{
		database_connection.readData(query);
	}

}
