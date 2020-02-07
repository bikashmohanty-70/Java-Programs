package com.bridgelabz.utility;

public class Stack<T> 
{
	Node top;
	class Node
	{
		T data;
		Node next;
		Node(T data)
		{
			this.data = data;
			this.next = null;
		}
	}

	public void push(T data)
	{
		Node newNode = new Node(data);
		if(top == null)
			top = newNode;
		else
		{
			Node currentNode = top;
			while(currentNode.next != null)
				currentNode = currentNode.next;
			currentNode.next = newNode;
		}
		
	}

	//	public void pop()
	//	{
	//		if(top == null)
	//			System.out.println("Stack is Empty");
	//		else
	//		{
	//			Node currentNode = top;
	//			Node previous = null;
	//			while(currentNode.next != null)
	//			{
	//				previous = currentNode;
	//				currentNode = currentNode.next;
	//			}
	//			previous.next = null;
	//		}
	//	}

	public T pop() 
	{
		T data = null;
		Node temp = top;
		if (top == null) 
		{
			System.out.println("Stack is Empty");
		} 
		else if (top.next == null) 
		{
			data = (T) top.data;
			top = null;
		} 
		else 
		{
			while (temp.next.next != null) 
			{
				temp = temp.next;
			}
			data = temp.next.data;
			temp.next = null;
		}
		return data;
	}

	public T peek()
	{
		T data = null;
		if(top == null)
			return data;
		else
		{
			Node currentNode = top;
			Node previous = null;
			while(currentNode.next != null)
			{
				previous = currentNode;
				currentNode = currentNode.next;
			}
			data = previous.data;
		}
		return data;
	}

	public int size()
	{
		int size = 0;
		Node currentNode = top;
		while(currentNode.next != null)
		{
			currentNode = currentNode.next;
			size++;
		}
		return size;
	}

	public void display()
	{
		Node currentNode = top;
		while(currentNode.next != null)
		{
			System.out.println(currentNode.data+" ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}

	public boolean isEmpty()
	{
		if(top == null)
			return true;
		else
			return false;
	}
}
