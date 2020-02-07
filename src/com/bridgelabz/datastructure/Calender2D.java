package com.bridgelabz.datastructure;

import com.bridgelabz.utility.InputUtility;
/**
 * @Author   :  Bikash Mohanty
 * @Version  :  1.0
 * @Date     :  23rd Nov 2019
 * Purpose   :  Takes the month and year as input and prints the Calendar of the month.
  				Store the Calendar in an 2D Array,the first dimension the week of the
  				month and the second dimension stores the day of the week.
 */
import com.bridgelabz.utility.Utility;

public class Calender2D {

	// Main method
	public static void main(String[] args) {

		System.out.println("Enter a month : ");
		int month = InputUtility.inputInteger();
		System.out.println("Enter a year : ");
		int year = InputUtility.inputInteger();

		int month1, x, day = 1, day1, year1;

		year1 = year - (14 - month) / 12;
		x = year1 + (year1 / 4) - (year1 / 100) + (year1 / 400);
		month1 = month + 12 * ((14 - month) / 12) - 2;
		day1 = (day + x + (31 * month1) / 12) % 7;
		
		System.out.println(day1);

		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] dayInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int monthDay = 0;
		// logic to check the day in month
		for (int i = 0; i < dayInMonth.length; i++) {
			if (i == month - 1) {
				monthDay = dayInMonth[i];
			}
		}
		// Initializing 2D array
		int[][] totalDays = new int[6][7];

		// logic to check leap year or not
		boolean leapYear = Utility.isLeapYear(year);
		if ((leapYear == true) && (month == 2)) {
			monthDay = 29;
		}

		int z = 1;
		// logic to check the total days in month
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (i == 0 && j < day1) {
					totalDays[i][j] = -1;
				} else if (z <= monthDay) {
					totalDays[i][j] = z;
					z++;
				} else {
					totalDays[i][j] = -1;
				}
			}
		}

		// logic to check the month of the year
		for (int i = 0; i < 12; i++) {
			if (month == i + 1) {
				System.out.println(monthName[i] + " " + year);
			}
		}
		System.out.println();

		String[] dayName = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (int i = 0; i < 7; i++) {
			System.out.print(dayName[i] + "\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------------------");

		// logic to print the calendar
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (totalDays[i][j] != -1) {
					if (totalDays[i][j] < 10)
						System.out.print(totalDays[i][j] + "\t");
					else
						System.out.print(totalDays[i][j] + "\t");
				} else
					System.out.print("\t");
			}
			System.out.println();
		}
	}
}

