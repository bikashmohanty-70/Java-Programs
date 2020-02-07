package com.bridgelabz.testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bridgelabz.junit.VendingMachine;

class VendingMachineTest 
{

	@Test
	void value_must_be_greater_than_zero() 
	{
		assertEquals(0, VendingMachine.minCoin(0, new int[]{1000, 500, 100, 50, 10, 5, 2, 1}));
		assertEquals(1, VendingMachine.minCoin(100, new int[]{1000, 500, 100, 50, 10, 5, 2, 1}));
		assertEquals(2, VendingMachine.minCoin(550, new int[]{1000, 500, 100, 50, 10, 5, 2, 1}));
		assertEquals(3, VendingMachine.minCoin(8, new int[]{1000, 500, 100, 50, 10, 5, 2, 1}));
		assertEquals(4, VendingMachine.minCoin(1025, new int[]{1000, 500, 100, 50, 10, 5, 2, 1}));
	}

}
