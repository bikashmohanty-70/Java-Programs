package com.bridgelabz.design_pattern.factory_pattern;

import com.bridgelabz.utility.InputUtility;

public class ParentFactory {
	public static void main(String[] args) {
		System.out.println("Enter Type (PC/Server): ");
		String type = InputUtility.inputString();
		System.out.println("ENter Ram: ");
		String ram = InputUtility.inputString();
		System.out.println("Hard Disk: ");
		String hdd = InputUtility.inputString();
		System.out.println("CPU: ");
		String cpu = InputUtility.inputString();

		Computers pc = ComputerFactory.getComputers(type, ram, hdd, cpu);
		Computers server = ComputerFactory.getComputers(type, ram, hdd, cpu);
		System.out.println("Factory PC Config::" + pc);
		System.out.println("Factory Server Config::" + server);
	}
}
