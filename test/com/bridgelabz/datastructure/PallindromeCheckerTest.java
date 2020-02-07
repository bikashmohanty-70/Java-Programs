package com.bridgelabz.testcases;

/**
 * @Author   :  Bikash Mohanty
 * @Version  :  1.0
 * @Date     :  23rd Nov 2019
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bridgelabz.datastructure.PallindromeChecker;

class PallindromeCheckerTest 
{

	@Test
	public void checkPallindrome_passing_hello()
	{
		Assertions.assertEquals(false,PallindromeChecker.checkPallindrome("hello"));
	}
	
	@Test
	public void checkPallindrome_passing_madam()
	{
		Assertions.assertEquals(true,PallindromeChecker.checkPallindrome("madam"));
	}

}
