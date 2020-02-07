package com.bridgelabz.address_book;
/**
 * @author Bikash Mohanty
 * @since 5th Dec 2019
 * @version 1.0
 * 
 * Purpose: Address Book
 */
import com.bridgelabz.utility.Utility;

public class Controller 
{

	public static void main(String[] args) 
	{
		IServiceInterface services = new ServiceImplementation();
		int choice = 0;
		do {
			System.out.println("-:Address Book:-");
			System.out.println("1. Add Address");
			System.out.println("2. View Address");
			System.out.println("3. Update Address");
			System.out.println("4. Remove Address");
			System.out.println("5. Exit");
			
			System.out.println("Enter Your Choice: ");
			choice = Utility.inputInteger();
			
			switch (choice) 
			{
				case 1:
					services.addAddress();
					break;
				
				case 2:
					services.readFromJSON();
					break;
				
				case 3:
					System.out.println("******************Update Record******************");
					services.updateAddress();
					break;
				
				case 4:
					services.removeAddress();
					break;
					
				default:
						break;
			}
		}while(true);

	}

}
