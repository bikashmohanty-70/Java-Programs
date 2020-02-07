package com.bridgelabz.datastructure;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * @author Bikash Mohanty
 * @version 1.0
 * @CreatedOn 22nd Nov 2019
 * 
 * purpose: Program which creates Banking Cash Counter where people come in to
 * 			deposit Cash and withdraw Cash. Have an input panel to add people
 * 			to Queue to either deposit or withdraw money and dequeue the people
 */

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class BankCashCounter 
{
	static Queue<Integer> queue = new Queue<>();
	static Queue<String> customers = new Queue<>();
	static int balance = 0;
	static String str;
	
	//To store the Current Time and Date
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd \t HH:mm:ss");  
	static LocalDateTime now = LocalDateTime.now();  
	
	
	/**
	 * 
	 * @param money-->integer
	 * @return balance in account --> integer
	 * Purpose: TO DEPOSIT MONEY
	 */
	public static int deposit(int money)
	{
		balance += money;
		return balance;
		
	}
	
	/**
	 * 
	 * @param money-->integer
	 * @return balance in account --> integer
	 * Purpose: TO WITHDRAW MONEY
	 */
	
	public static int withdraw(int money)
	{
		balance -= money;
		return balance;
	}
	
	/**
	 * 
	 * @return string value as the ticketNumbers in queue must be stored in String
	 */
	public static String ticketNumber() 
	{
		str = customers.deQueue();
		return str;
	}
	
	/**
	 * 
	 * @param <T> Generic Method
	 * 
	 * Purpose: To Print Whatever the Data Are returned from the Queue as same as a Bank Mini statement
	 */
	
	static <T> void miniStatements()
	{

		ArrayList<Integer> list = queue.displayEach();
		System.out.println("Date \t\t Time \t\t Transactions");
		System.out.println("---------------------------------------------");
		for(int i = 0; i < list.size(); i++ )
		{
			System.out.println(dtf.format(now)+ " \t " +list.get(i));
		}
		
	}
	
	
	//Main Method

	public static void main(String[] args) 
	{
		int ch = 0;
		
		System.out.print("Number of Customers in the Queue: ");
		int customers_in_queue = Utility.inputInteger();
		System.out.println("Enter Ticket Numbers of those CUstomers: ");
		
		for (int i = 0; i < customers_in_queue; i++) 
		{
			customers.enQueue(now, Utility.inputString());	//to store the customers in a queue
		}
		
		System.out.println();
		
		System.out.print("Tickets in Queue: ");
		customers.display();
		
		str = customers.deQueue(); //deQueuing the First Customer or ticket from the Queue
		
		do
		{
			
			System.out.println("\nTicket Number: "+str+ "\n");
			System.out.println("1. DEPOSIT\n2. WITHDRAW\n3. MINI STATEMENT\n4. PEOPLE IN QUEUE\n5. EXIT");
			System.out.print("Eneter Choice: ");
			ch = Utility.inputInteger();
			
			switch (ch) 
			{
			case 1:
				System.out.print("\nEnter Amount to Deposit: ");
				int amount = Utility.inputInteger();
				queue.enQueue(now, amount);
				System.out.println("You've Successfully Deposited your Amount");
				System.out.print("Current Balance: "+ deposit(amount));
				System.out.println();
				
				break;
				
			case 2:
				System.out.println("Enter Amount to Withdraw: ");
				int amountWithdraw = Utility.inputInteger();
				if(balance >= amountWithdraw)
				{
					queue.enQueue(now, amountWithdraw);
					System.out.println("Withdraw SuccessFull\n");
					System.out.println("Currrent Balance: " +withdraw(amountWithdraw));
				}
				else
					System.out.println("Less Amount in Your Account... Can't Withdraw...!!");
				break;
				
			case 3:
				System.out.println("All Transactions of today: ");
				miniStatements();
				break;
				
			case 4:
				System.out.println("People in Queue");
				customers.display();
				break;
			
			case 5:
				System.out.println("***************** Thank you *******************");
				balance = 0;
				ticketNumber();
				queue = new Queue<>();
				break;

			default:
				System.out.println("Wrong Input");
				System.exit(0);
				break;
			}
			
		}while(ch < 6);
		

	}

}
