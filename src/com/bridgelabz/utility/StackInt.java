package com.bridgelabz.utility;

public class StackInt 
{
	static int capacity = 2;
	static int top = 0;
	static int [] stack = new int[capacity];

	public static void push(int data)
	{
		if(size() == capacity)
			expand();
		stack[top] = data;
		top++;

	}
	private static void expand() 
	{
		int length = size();
		int[] newStack = new int[capacity*2];
		
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		capacity *= 2;
	}
	public static int pop()
	{
		int data = 0;

		if(isEmpty())
			System.out.println("Stack is Empty..!!");
		else 
		{	
			
			top--;
			System.out.println("\nTop New Top "+top);
			System.out.println("Top "+stack[top]);
			data = stack[top];
			System.out.println("Data "+stack[top]);
			System.out.println("Top New "+top);
			stack[top] = 0;
			System.out.println("0th index"+stack[0]);
			System.out.println("0th index"+stack[1]);
			shrink();
		}
		return data;
	}

	private static void shrink() 
	{
		int length = size();
		if(length <= (capacity/2)/2)
			capacity = capacity/2;
		int [] newStack = new int [capacity];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
	}
	public static int peek() 
	{
		int data;
		data = stack[top - 1];
		return data;
	}

	public static int size()
	{
		return top;
	}

	public static boolean isEmpty()
	{
		return top <= 0;
	}

	public static void show()
	{
		for(int n : stack)
			System.out.print(n + " ");
		System.out.println();
	}

}
