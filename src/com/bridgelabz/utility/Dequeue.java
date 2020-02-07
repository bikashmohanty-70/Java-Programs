package com.bridgelabz.utility;
/**
 * @Author : Bikash Mohanty
 * @Version : 1.0
 * @Date : 22nd Nov, 2019
 * Purpose : Generic Dequeue
 */
public class Dequeue<T> 
{
	Node head;

	class Node 
	{
		T data;
		Node next;

		// constructor
		public Node(T data) 
		{
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * @purpous add item at front of the dequeue
	 * @param Generic type item
	 */
	
	public void addFront(T item) 
	{
		Node node = new Node(item);
		if (head == null) 
		{
			head = node;
		} 
		else 
		{
			node.next = head;
			head = node;
		}
	}

	/**
	 * @purpose Adding the element in rear.
	 * @param Generic type item
	 */

	public void addRear(T item) 
	{
		Node node = new Node(item);
		Node current = head;
		if (head == null) 
		{
			head = node;
		} 
		else 
		{
			while (current.next != null) 
			{
				current = current.next;
			}
			current.next = node;
			node = current;
		}
	}

	/**
	 * @purpose Removing the elements of DeQueue from front
	 * @return data stored in head
	 */
	public T removeFront() 
	{
		T data = head.data;
		head = head.next;
		return data;
	}

	/**
	 * @purpose Removing the elements of DeQueue from rear
	 * @return data stored in last node
	 */
	public T removeRear() 
	{
		Node current = head;
		T data = null;
		Node prev = null;	
		while (current.next != null) 
		{
			prev = current;
			current = current.next;
		}
		data = current.data;
		prev.next = null;
		return data;
	}

	/**
	 * @purpose Checking whether list is empty or not
	 * @return boolean
	 */
	public boolean isEmpty() 
	{
		if (head == null) 
			return true;
		
		else
			return false;
	}

	/**
	 * @purpose returning size of deQueue
	 * @return Integer Size
	 */
	public int size() 
	{
		Node current = head;
		int size = 0;
		if (head == null) 
		{
			System.out.println("Queue is empty");
		} 
		else 
		{
			while (current != null) 
			{
				size++;
				current = current.next;
			}
			return size;
		}
		return -1;
	}

	/**
	 * @purpose Displaying the elements of DeQueue
	 * @return void
	 */
	public void show() 
	{
		Node current = head;
		if (head == null) 
		{
			System.out.println("list is empty..!!");
		} 
		else 
		{
			while (current.next != null) 
			{
				System.out.print(current.data + "");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}
}
