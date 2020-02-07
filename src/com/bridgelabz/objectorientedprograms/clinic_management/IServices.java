package com.bridgelabz.clinic_management;

/**
 *@Author   :  Bikash Mohanty
 *@Version  :  1.0
 *@Date     :  5th Dec 2019
 */
import org.json.simple.JSONObject;

public interface IServices 
{
	
	void addPatients();
	void addDoctors();
	JSONObject readDetails(String filename);
	void readDoctorDetails(String key, String value);
	void readPatientDetails(String key, String value);
	String generateId();
	void updatePatients();
	void updateDoctors();
}
