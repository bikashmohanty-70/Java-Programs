package com.bridgelabz.utility;

/** 
 *
 *  @author  Bikash Mohanty
 *  @version 1.0
 *  @since   3rd Dec 2019
 *  
 *  Purpose: Stack implementation
 *
 */

/*
 * Generic version of the LinkedList class.
 * 
 * @param <T> the type of the value
 */
public class Stack<T> 
{

	Node<T> head;
	int count = 0;

	@SuppressWarnings("hiding")
	class Node<T> 
	{
		Node<T> next;
		T data;

		Node(T data) 
		{
			this.data = data;
		}
	}

	public Stack() 
	{
		this.head = null;
	}

	public void push(T data) 
	{
		Node<T> new_node = new Node<T>(data);
		new_node.next = head;
		head = new_node;
		count++;
	}

	
	public void pop() 
	{
		if (head == null) 
		{
			System.out.println("Stack UnderFlow");
			return;
		}
		Node<T> temp = head;
		head = temp.next;
		temp = null;
		count--;
	}


	public T peek() 
	{
		if (head == null) 
		{
			System.out.println("no data present");
		}
		T temp = head.data;
		return temp;
	}

	public int size() 
	{
		return count;

	}

	public boolean isEmpty()
	{
		if (count == 0) 
			return false;
		return true;

	}

	public void display() 
	{
		Node<T> temp = head;
		if (temp == null) 
		{
			System.out.println("Stack UnderFlow");
			return;
		} 
		else 
		{
			while (temp != null) 
			{
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) 
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println("push data");
		stack.display();

		stack.pop();
		System.out.println("pop data");
		stack.display();

		System.out.println("size of the data");
		int size = stack.size();
		System.out.println("size " + size);

		System.out.println("check empty ");
		boolean result = stack.isEmpty();
		if (result == true)
			System.out.println("Not a empty stack");
		else
			System.out.println("empty stack");

		System.out.println("peek data");
		int result1 = stack.peek();
		System.out.println(result1);
	}
}
