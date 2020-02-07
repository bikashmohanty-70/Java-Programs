package com.bridgelabz.design_pattern.structural_design_pattern.facade_design_pattern;
/**
 * 
 * @author Bikash Mohanty
 * @since 9th Dec 2019
 * @version 1.0
 * 
 * Purpose: This class is MySQL Database operation class
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase 
{
	private Connection connection;
	private Statement statement;
	
//	public ConnectDatabase() throws ClassNotFoundException
//	{
//		Class.forName("com.mysql.jdbc.Driver");
//	}
	
	public void createConnection(String url, String username, String password) throws SQLException
	{
		connection = DriverManager.getConnection(url,username,password);
	}
	public void createStatement() throws SQLException
	{
		statement = connection.createStatement();
	}
	
	//Database Operations
	/*------------------------------------*/
	
	//Create Table
	
	
	public void createTable(String sqlQuery)
	{
		try 
		{
			statement.executeUpdate(sqlQuery);
		} 
		catch (SQLException e) 
		{
			System.out.println("TABLE ALREADY CREATED: "+e.getStackTrace());
		}
	}
	
	//Insert Into Table
	public int insertIntoTable(String sqlQuery) throws SQLException
	{
		return statement.executeUpdate(sqlQuery);
	}
	
	//Read from Table
	public void readData(String query)
	{
		ResultSet resultSet = null;
		try 
		{
			resultSet = statement.executeQuery(query);
			while(resultSet.next())
				System.out.println("Name: "+resultSet.getString(2)+ " "+ resultSet.getString(3)+ "\nAddress: "+ resultSet.getString(4)+ "\nCity "+ resultSet.getString(5)+
						"\nState: "+resultSet.getString(6)+ "\nZip: "+ resultSet.getString(7)+ "\nCOntact: "+ resultSet.getString(8)+"\n\n");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(resultSet != null)
					resultSet.close();
			} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
			
		}
			
	}
	
	
	
}
