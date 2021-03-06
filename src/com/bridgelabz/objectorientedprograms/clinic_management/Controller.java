package com.bridgelabz.clinic_management;

import com.bridgelabz.utility.InputUtility;

/**
 *@Author   :  Bikash Mohanty
 *@Version  :  1.0
 *@Date     :  5th Dec 2019
 *Purpose   :  Clinic Management System
 */

public class Controller 
{
	private static final String FILENAME = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\Patients.json";
	private static final String DOCTOR_FILE = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\Doctors.json";
	public static void main(String[] args) {

		IServices service = new ServicesImplementation();
		int ch = 0;
		do {
			System.out.println("\tClinique Management\n-----------------------------------");
			System.out.println("\tChoose any one : ");
			System.out.println("\t1. Patients Entry");
			System.out.println("\t2. Doctors Entry");
			System.out.println("\t3. Exit ");
			int choice = InputUtility.inputInteger();
			switch (choice) {
			case 1:
				System.out.println("\t\t-:Patients File:- \n\t-----------------------------------");
				System.out.println("\t\t1. Add Patients");
				System.out.println("\t\t2. View patients File");
				System.out.println("\t\t3. Search Patients");
				System.out.println("\t\t4. Update Patient's Records");
				int choice1 = InputUtility.inputInteger();
				switch (choice1) {
				case 1:
					service.addPatients();
					break;

				case 2:
					System.out.println(service.readDetails(FILENAME));
					break;

				case 3:
					System.out.print("Enter Patient's Name :");
					String patientId = InputUtility.inputString();
					service.readPatientDetails("Id", patientId); // converting integer to string
					break;

				case 4:
					service.updatePatients();
					break;

				default:
					System.out.println("Invalid");
				}
				break;

			case 2:
				System.out.println("\t\t-:Doctors File:- \n\t-----------------------------------");
				System.out.println("\t\t1. Add Doctors");
				System.out.println("\t\t2. View Doctors File");
				System.out.println("\t\t3. Search Doctor");
				System.out.println("\t\t4. Update Doctor's Record");
				int choice2 = InputUtility.inputInteger();
				switch (choice2) {
				case 1:
					service.addDoctors();
					break;

				case 2:
					System.out.println(service.readDetails(DOCTOR_FILE));
					break;

				case 3:
					System.out.print("Enter a Name :");
					//int doctorId = InputUtility.inputInteger();
					String docName = InputUtility.inputString();
					service.readDoctorDetails("Id", docName);
					break;

				case 4:
					service.updateDoctors();
					break;

				default:
					System.out.println("Invalid");
				}
				break;

			case 3:
				System.out.println("Thank You");
				System.exit(0);

			default:
				System.out.println("Invalid");
			}

		} while (ch < 3);

	}


}


