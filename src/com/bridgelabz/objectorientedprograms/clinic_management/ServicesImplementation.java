package com.bridgelabz.clinic_management;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;

/**
 *@Author   :  Bikash Mohanty
 *@Version  :  1.0
 *@Date     :  2019/12/05
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.bridgelabz.utility.Utility;


public class ServicesImplementation implements IServices 
{

	static final String PATH_PATIENTS = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\Patients.json";
	static final String PATH_DOCTORS = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\Doctors.json";
	static final String PATH_APPOINTMENT = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\AppointmentRecord.json";
	static final String APPOINTMENT_SCHEDULED = "C:\\Users\\Admin\\eclipse-workspace\\Object Orientend Programmings\\JSON\\ScheduledAppointment.json";
	JSONParser parser = new JSONParser();

	
	/**
	 * Date And Time
	 */
		
//	LocalDateTime datetime = LocalDateTime.now();
//	DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ISO_LOCAL_DATE;
//	String formattedDate2 = dateTimeFormatter2.format(datetime);
	
	LocalDate sourceDate = LocalDate.of(2019, Month.DECEMBER, 23);  // Source Date
	LocalDate destDate = sourceDate.plusDays(1); // Adding a day to source date.
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Setting date format
	String destDate1 = destDate.format(formatter);  // End date
	

	Patients patient = new Patients(); // creating an object of Patients class
	Doctors doctor = new Doctors(); // creating an object of Doctors class

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd :: HH:mm a");  
	static LocalDateTime now = LocalDateTime.now();
	String time = dtf.format(now);
	boolean appointment = false;

	JSONObject rootObject = new JSONObject();
	JSONObject doctorObject = null;	// Used for storing Doctor's Details
	JSONObject patientObject = null;
	JSONObject storingObject = new JSONObject();
	JSONArray arrayOfAppointment = new JSONArray();


	JSONObject newDateObj = new JSONObject();
	JSONObject storeScheduledAppointment = null;
	JSONObject innerObject = null;
	JSONArray tempPatient = new JSONArray();

	//For displyDoctors()
	JSONObject displayDoctors = new JSONObject();
	JSONObject tempStore = new JSONObject();

	JSONObject appointmentFile = new JSONObject();
	/**
	 *  function to add patients details in a file
	 */
	@SuppressWarnings("unchecked")
	public void addPatients() 
	{
		patientObject = new JSONObject();

		System.out.println("Enter Patient Information\n");

		System.out.println("Name : ");
		patient.setName(Utility.inputString());
		patientObject.put("Name", patient.getName());

		System.out.println("Age : ");
		patient.setAge(Utility.inputInteger());
		patientObject.put("Age", patient.getAge());

		String patientId = generateId();
		patient.setId(patientId);
		patientObject.put("ID", patient.getId());

		System.out.println("Mobile number :");
		patient.setMobile_number(Utility.inputLong());
		patientObject.put("Mobile_Number", patient.getMobile_number());

		patientObject.put("Registered_On", dtf.format(now));

		dipalyAvailableDoctors();

		System.out.println("Take Appointment of a (Doctor's Name/Speciality): ");
		String doctorName = Utility.inputString();

		appointment(patientObject, doctorName);

	}


	/**
	 * 
	 * @param appointmentObject ---> JSONObject
	 * @param nameOfDoctor ---> String
	 * 
	 * purpose: This Function will check whether it's possible to Take an Appointment or not
	 */


	@SuppressWarnings({ "unchecked" })
	private void appointment(JSONObject appointmentObject, String nameOfDoctor) //Catching PatientObject Details as appointmentObject
	{

		//System.out.println(appointmentObject.toJSONString());
		if(ReadWriteJSONClinicManagement.readFile(PATH_DOCTORS) != null) 
		{
			doctorObject = ReadWriteJSONClinicManagement.readFile(PATH_DOCTORS);

			JSONObject tempDoctorObject = (JSONObject) doctorObject.get(nameOfDoctor);
			//System.out.println(tempDoctorObject.toJSONString());
			JSONObject doctorAppointment = new JSONObject(); 

			JSONArray appointmentArray = (JSONArray) tempDoctorObject.get("Appointments");
			if(appointmentArray.size() < 5)
			{
				doctorAppointment.put(appointmentObject.get("ID"),appointmentObject.get("Name"));


				appointmentArray.add(doctorAppointment);
				tempDoctorObject.put("Appointments", appointmentArray);
				doctorObject.put(nameOfDoctor, tempDoctorObject);
				//System.out.println(doctorObject.toJSONString());
				ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, doctorObject);
				appointmentObject.put("Consulting", nameOfDoctor);

				if( ReadWriteJSONClinicManagement.readFile(PATH_PATIENTS) != null)
				{
					storingObject = ReadWriteJSONClinicManagement.readFile(PATH_PATIENTS);
					storingObject.put(appointmentObject.get("Name"),appointmentObject);
					this.appointment = true;
				}
				else
				{
					storingObject.put(appointmentObject.get("Name"), appointmentObject);
				}

				ReadWriteJSONClinicManagement.writeToFile(PATH_PATIENTS, storingObject);
				this.appointment = true;
			}
			else 
			{
				System.out.println("Sorry...!!\nDoctor is Busy Today...\nWe'll schedule an appointment for you for Tomorrow.");
//				JSONObject tempDocObj = (JSONObject) newDateObj.get(nameOfDoctor);
				
				tempPatient.add(appointmentObject.get("Name"));
				newDateObj.put(destDate1, tempPatient);
				//storeScheduledAppointment.put(nameOfDoctor, newDateObj);
				
				if(ReadWriteJSONClinicManagement.readFile(APPOINTMENT_SCHEDULED) != null)
				{
					storeScheduledAppointment = ReadWriteJSONClinicManagement.readFile(APPOINTMENT_SCHEDULED); //Reading Patient's Appointment File					
					storeScheduledAppointment.put(nameOfDoctor, newDateObj);
					//System.out.println(storeScheduledAppointment.toJSONString());
				}
				else
				{
					storeScheduledAppointment.put(nameOfDoctor, newDateObj);
				}
				ReadWriteJSONClinicManagement.writeToFile(APPOINTMENT_SCHEDULED, storeScheduledAppointment);
				
				//System.out.println(storeScheduledAppointment.toJSONString());
				this.appointment = false;
			}

			if(this.appointment == true)
				storeAppointmentsInFile(doctorObject, nameOfDoctor);
		}

	}

	/**
	 * 
	 * @param doctorDetails --> JSONObject
	 * @param doctorName --> String
	 * 
	 * Purpose: This method store the patient's record who have taken appointment in AppointmentRecord file 
	 */

	@SuppressWarnings("unchecked")
	private void storeAppointmentsInFile(JSONObject doctorDetails, String doctorName) 
	{
		JSONObject temporaryObject = (JSONObject) doctorDetails.get(doctorName);	//Accessing Object of a particular Doctor Object
		JSONArray toBeAttended = (JSONArray) temporaryObject.get("Appointments"); //Accessing Array Elements from Object
		JSONObject tempStore = new JSONObject();
		//System.out.println("ToBeAttended "+toBeAttended.toJSONString());
		Iterator<?> iteratorOfTobeAttendedObject = toBeAttended.iterator();
		int i = 0;
		while(iteratorOfTobeAttendedObject.hasNext() && i < toBeAttended.size())
		{
			tempStore.put(doctorName, toBeAttended.get(i));
			//System.out.println(toBeAttended.get(i));
			i++;
		}
		//System.out.println(tempStore.toJSONString());

		if(ReadWriteJSONClinicManagement.readFile(PATH_APPOINTMENT) != null)
		{
			appointmentFile = ReadWriteJSONClinicManagement.readFile(PATH_APPOINTMENT); //Reading Patient's Appointment File			
			appointmentFile.put(doctorName, toBeAttended);
		}
		else
		{
			appointmentFile.put(doctorName, toBeAttended);
		}
		ReadWriteJSONClinicManagement.writeToFile(PATH_APPOINTMENT, appointmentFile);
	}



	@SuppressWarnings("unchecked")
	/**
	 *  function to add doctors details in a file
	 */
	public void addDoctors() 
	{
		doctorObject = new JSONObject();

		System.out.println("Enter Doctor Information\n");

		System.out.println("Enter a name : ");
		doctor.setName(Utility.inputString());
		doctorObject.put("Name", doctor.getName());

		String doctorId = generateId();
		doctor.setId(doctorId);
		doctorObject.put("ID", doctor.getId());

		System.out.println("Enter a specialization : ");
		doctor.setSpecialization(Utility.inputString());
		doctorObject.put("Specialization", doctor.getSpecialization());

		System.out.println("Enter time of availability : ");
		doctor.setAvailability(Utility.inputString());
		doctorObject.put("Availability", doctor.getAvailability());

		doctorObject.put("Appointments", arrayOfAppointment); //Unusual try


		//doctorObject.put("ID",doctor.getId());

		System.out.println(doctorObject.toJSONString()+" "+doctor.getName());
		//		rootObject = readDetails(PATH_DOCTORS);
		//		rootObject.put(doctor.getName(), doctorObject);

		try 
		{

			if( ReadWriteJSONClinicManagement.readFile(PATH_DOCTORS) !=null)
			{
				rootObject = ReadWriteJSONClinicManagement.readFile(PATH_DOCTORS);
				rootObject.put(doctor.getName(), doctorObject);
			}
			else
			{
				rootObject.put(doctor.getName(), doctorObject);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, rootObject);
	}

	/**
	 *  function to read details from file
	 * 
	 * @param FILENAME
	 * @return JSONObject
	 */
	public JSONObject readDetails(String filename) 
	{
		String string = Utility.readFromFile(filename);
		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(string);
			return objectFile;
		} 
		catch (Exception e) 
		{
			System.out.println("File is Empty... But Dont Worry...");
		}
		return null;

	}

	/**
	 *function to search and read doctor details from file
	 * 
	 * @param key
	 * @param docName
	 */
	public void readDoctorDetails(String key, String docName) 
	{
		String string = Utility.readFromFile(PATH_DOCTORS);
		JSONParser parser = new JSONParser();

		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(string);
			innerObject = (JSONObject) objectFile.get(docName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("\nDoctor Information:");
		System.out.println("Name: " + innerObject.get("Name") + "\t");
		System.out.println("ID: " + innerObject.get("ID") + "\t");
		System.out.println("Specialization: " + innerObject.get("Specialization") + "\t");
		System.out.println("Availability: " + innerObject.get("Availability") + "\t");
	}

	/**
	 * function to search and read patients details from file
	 * 
	 * @param key
	 * @param value
	 */
	public void readPatientDetails(String key, String value) 
	{
		String string = Utility.readFromFile(PATH_PATIENTS);
		JSONParser parser = new JSONParser();
		JSONObject innerObject = null;
		JSONObject objectFile = null;
		try 
		{
			objectFile = (JSONObject) parser.parse(string);
			innerObject = (JSONObject) objectFile.get(value);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		System.out.println("\nPatient Information:");
		System.out.println("Name: " + innerObject.get("Name") + "\t");
		System.out.println("ID: " +innerObject.get("ID") + "\t");
		System.out.println("Mobile_Number :" + innerObject.get("Mobile_Number") + "\t");
		System.out.println("Age :" + innerObject.get("Age") + "\t");
	}

	/**
	 *  function to generate random id
	 * 
	 * @return String
	 */
	public String generateId() 
	{
		//Random random = new Random();
		//		String alphabet = "123xyz";
		//		return alphabet.charAt(random.nextInt(alphabet.length()))
		//return String.valueOf(random.nextInt(1000) + 1);

		// chose a Character random from this String 
		int n = 8;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789"
				+ "abcdefghijklmnopqrstuvxyz"; 

		// create StringBuffer size of AlphaNumericString 
		StringBuilder sb = new StringBuilder(n); 

		for (int i = 0; i < n; i++) 
		{ 

			// generate a random number between 
			// 0 to AlphaNumericString variable length 
			int index 
			= (int)(AlphaNumericString.length() 
					* Math.random()); 

			// add Character one by one in end of sb 
			sb.append(AlphaNumericString 
					.charAt(index)); 
		} 

		return sb.toString(); 
	}

	/**
	 *  function to update patient's details
	 */
	@SuppressWarnings("unchecked")
	public void updatePatients() {
		JSONObject updateObject = new JSONObject();
		JSONObject innerObject = null;
		updateObject = readDetails(PATH_PATIENTS);

		System.out.print("Enter a ID :");
		int patientId = Utility.inputInteger();
		String value = Integer.toString(patientId);

		innerObject = (JSONObject) updateObject.get(value);

		System.out.println("Patient Information:");
		System.out.println("Name: " + innerObject.get("Name") + "\t");
		System.out.println("Mobile_Number :" + innerObject.get("Mobile_Number") + "\t");
		System.out.println("Age :" + innerObject.get("Age") + "\t");

		System.out.println("\nWhich key value you want to update ");
		System.out.println("1. Name ");
		System.out.println("2. Age ");
		System.out.println("3. Mobile Number ");
		System.out.println("4. All details ");
		int choice = Utility.inputInteger();

		switch (choice) 
		{
		case 1:
			System.out.println("Enter a new name : ");
			patient.setName(Utility.inputString());
			innerObject.replace("Name", patient.getName());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;

		case 2:
			System.out.println("Enter new age :");
			patient.setAge(Utility.inputInteger());
			innerObject.replace("Age", patient.getAge());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;
		case 3:
			System.out.println("Enter new mobile number");
			patient.setMobile_number(Utility.inputLong());
			innerObject.replace("Mobile_Number", patient.getMobile_number());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;

		case 4:
			System.out.println("Enter a new name : ");
			patient.setName(Utility.inputString());
			innerObject.replace("Name", patient.getName());

			System.out.println("Enter new age :");
			patient.setAge(Utility.inputInteger());
			innerObject.replace("Age", patient.getAge());

			System.out.println("Enter new mobile number");
			patient.setMobile_number(Utility.inputLong());
			innerObject.replace("Mobile_Number", patient.getMobile_number());

			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;

		}
	}

	/**
	 * function to update doctor's details
	 */
	@SuppressWarnings("unchecked")
	public void updateDoctors() {
		JSONObject updateObject = new JSONObject();
		JSONObject innerObject = null;
		updateObject = readDetails(PATH_DOCTORS);

		System.out.print("Enter a ID :");
		int doctorId = Utility.inputInteger();
		String value = Integer.toString(doctorId);

		innerObject = (JSONObject) updateObject.get(value);

		System.out.println("Doctor Information:");
		System.out.println("Name: " + innerObject.get("Name") + "\t");
		System.out.println("Specialization: " + innerObject.get("Specialization") + "\t");
		System.out.println("Availability: " + innerObject.get("Availability") + "\t");

		System.out.println("Which key value you want to update ");
		System.out.println("1. Name ");
		System.out.println("2. Specialization ");
		System.out.println("3. Availability ");
		System.out.println("4. All details ");
		int choice = Utility.inputInteger();
		switch (choice) {
		case 1:
			System.out.println("Enter a new name : ");
			doctor.setName(Utility.inputString());
			innerObject.replace("Name", doctor.getName());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;

		case 2:
			System.out.println("Enter new Specialization :");
			doctor.setSpecialization(Utility.inputString());
			innerObject.replace("Specialization", doctor.getSpecialization());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;
		case 3:
			System.out.println("Enter new Availability");
			doctor.setAvailability(Utility.inputString());
			innerObject.replace("Availability", doctor.getAvailability());
			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;

		case 4:
			System.out.println("Enter a new name : ");
			doctor.setName(Utility.inputString());
			innerObject.replace("Name", doctor.getName());

			System.out.println("Enter new Specialization :");
			doctor.setSpecialization(Utility.inputString());
			innerObject.replace("Specialization", doctor.getSpecialization());

			System.out.println("Enter new Availability");
			doctor.setAvailability(Utility.inputString());
			innerObject.replace("Availability", doctor.getAvailability());

			updateObject.put(value, innerObject);
			ReadWriteJSONClinicManagement.writeToFile(PATH_DOCTORS, updateObject);
			break;
		}
	}

	private void dipalyAvailableDoctors() 
	{
		displayDoctors = ReadWriteJSONClinicManagement.readFile(PATH_DOCTORS);
		System.out.println("\t\tOur Doctors Always There For You\n\t------------------------------------------------\n");
		Set<?> setOfKeys = displayDoctors.keySet();
		Iterator<?> iterKeyObject = setOfKeys.iterator();
		do{
			String k = iterKeyObject.next().toString();
			tempStore = (JSONObject) displayDoctors.get(k);
			System.out.print("  ["+tempStore.get("Name")+"]\t  ");
			//System.out.println("\t\t"+k);

		}while(iterKeyObject.hasNext());

		System.out.println();
		Set<?> keySets = displayDoctors.keySet();
		Iterator<?> iterKey = keySets.iterator();

		do{
			String key = iterKey.next().toString();
			tempStore = (JSONObject) displayDoctors.get(key);
			System.out.print("\t"+tempStore.get("Specialization")+"\t\t");
			//System.out.println("\t\t"+k); 

		}while(iterKey.hasNext());
		System.out.println("\n");
	}



}
