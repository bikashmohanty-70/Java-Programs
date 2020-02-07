package com.bridgelabz.inventorymanagement;

import org.json.simple.JSONObject;

/**
 *@Author   :  Bikash Mohanty
 *@Version  :  1.0
 *@Date     :  2019/12/01
 */
public interface IService 
{
	public JSONObject addDetails();
	public void readFile();
	public double totalWeight();
    public double totalPrice();
	public double price(String item);
}
