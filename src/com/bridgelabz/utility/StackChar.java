package com.bridgelabz.utility;

public class StackChar
{
	int capacity = 2;
	public int top = 0;
	char [] stack = new char[capacity];

	public void push(char data)
	{
		if(size() == capacity)
			expand();
		stack[top] = data;
		top++;

	}
	private void expand() 
	{
		int length = size();
		char[] newStack = new char[capacity*2];
		
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		capacity *= 2;
	}
	public char pop()
	{
		char data = 0;

		if(isEmpty())
			System.out.println("Stack is Empty..!!");
		else 
		{	
			top--;
			data = (char) stack[top];
			stack[top] = 0;
			shrink();
		}
		return data;
	}

	private void shrink() 
	{
		int length = size();
		if(length <= (capacity/2)/2)
			capacity = capacity/2;
		char [] newStack = new char [capacity];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
	}
	public int peek() 
	{
		int data;
		data = stack[top - 1];
		return data;
	}

	public int size()
	{
		return top;
	}

	public boolean isEmpty()
	{
		return top <= 0;
	}

	public void show()
	{
		for(char n : stack)
			System.out.print(n + " ");
		System.out.println();
	}

}
