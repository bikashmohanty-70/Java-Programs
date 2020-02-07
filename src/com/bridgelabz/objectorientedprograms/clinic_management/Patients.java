package com.bridgelabz.clinic_management;

/**
 * @Author : Bikash Mohanty
 * @Version : 1.0
 * @Date : 5th Dec 2019
 */
public class Patients 
{
	private String name;
	private String id;
	private long mobile_number;
	private int age;

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

	public void setId(String patientId) 
	{
		this.id = patientId;
	}

	public long getMobile_number() 
	{
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) 
	{
		this.mobile_number = mobile_number;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	// constructor
	public Patients(String name, String id, long mobile_number, int age) {
		this.name = name;
		this.id = id;
		this.mobile_number = mobile_number;
		this.age = age;
	}

	public Patients() 
	{

	}

}
