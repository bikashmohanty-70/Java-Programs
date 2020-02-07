package com.bridgelabz.testcases;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.bridgelabz.functional_programs.Triplets;

class TestTriplets 
{

	@Test
	void test() 
	{
		int[] array = {1, 2 , 3, 0, -1};
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {-2, 1, 3, -3, -1, 2, 4}; 
		Assert.assertEquals(Arrays.asList(1,0,-1), Triplets.triplets(array, array.length));
		Assert.assertEquals(Arrays.asList(), Triplets.triplets(array1, array1.length));
		Assert.assertEquals(Arrays.asList(-2, 3, -1, 1, -3, 2, -3, -1, 4), Triplets.triplets(array2, array2.length));
	}

}
