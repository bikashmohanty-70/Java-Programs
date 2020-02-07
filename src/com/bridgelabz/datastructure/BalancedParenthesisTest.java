package com.bridgelabz.datastructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BalancedParenthesisTest 
{

	@Test
	void testBalancedParenthesesWithNoBracketsExpressions() 
	{
		String exp="23*32";
		char [] ch=exp.toCharArray();
		int length=ch.length;
		assertEquals(true, BalancedParentheses.checkParentheses(ch, length));

		exp="23*32-589+59";
		char [] ch1=exp.toCharArray();
		length=ch.length;
		assertEquals(true, BalancedParentheses.checkParentheses(ch1, length));
	}

	@Test
	void testBalancedParenthesesWithSingleParenthesesExpressions()
	{
		String exp="23*32)";
		char [] ch=exp.toCharArray();
		int length=ch.length;
		assertEquals(false, BalancedParentheses.checkParentheses(ch, length));

		exp="(23*32-589+59";
		char [] ch1=exp.toCharArray();
		length=ch.length;
		assertEquals(false, BalancedParentheses.checkParentheses(ch1, length));
	}
	
	@Test
	void testBalancedParenthesesWithEqualParenthesesExpressions()
	{
		String exp="(23*32)";
		char [] ch=exp.toCharArray();
		int length=ch.length;
		assertEquals(true, BalancedParentheses.checkParentheses(ch, length));

		exp="(23*32)-(589+59)";
		char [] ch1=exp.toCharArray();
		length=ch.length;
		assertEquals(true, BalancedParentheses.checkParentheses(ch1, length));
	}

}
