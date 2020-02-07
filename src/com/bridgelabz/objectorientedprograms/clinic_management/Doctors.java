package com.bridgelabz.clinic_management;


/**
 * @Author : Bikash Mohanty
 * @Version : 1.0
 * @Date : 5th Dec 2019
 */
public class Doctors 
{
	private String name;
	private String id;
	private String specialization;
	private String availability;

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getSpecialization() 
	{
		return specialization;
	}

	public void setSpecialization(String specialization) 
	{
		this.specialization = specialization;
	}

	public String getAvailability() 
	{
		return availability;
	}

	public void setAvailability(String availability) 
	{
		this.availability = availability;
	}

	// constructor
	public Doctors(String name, String id, String specialization, String availability) {
		this.name = name;
		this.id = id;
		this.specialization = specialization;
		this.availability = availability;
	}

	public Doctors() 
	{
	}
}
