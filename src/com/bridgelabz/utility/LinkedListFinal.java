package com.bridgelabz.utility;
/**
 * @Author : Bikash Mohanty
 * @Version : 1.0
 * @Date : 22nd Nov, 2019
 * Purpose : Generic LinkedList
 */

public class LinkedListFinal<T> 
{
	Node head;

	public class Node 
	{
		Node next;
		T data;

		public Node(T data) 
		{
			this.data = data;
			this.next = null;
		}
	}

	public void add(T data) 
	{
		Node node = new Node(data);
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
		}
	}

	/**
	 * removing from end of linked list.
	 */
	public T pop() 
	{
		Node current = head;
		T data=null;
		if (head == null) 
		{
			System.out.println("List is Empty..!!");
		} 
		else 
		{
			while (current.next.next != null) 
			{
				current = current.next;
			}
			System.out.println("Removed element :" + current.next.data);
			data = (T)current.data;
			current.next = null;
		}
		return data;
	}

	/**
	 * Removing from list
	 */
	public void remove() 
	{
		Node current = head;
		if (head == null) 
		{
			System.out.println("List is Empty..!!");
		} 
		else
		{
			while (current.next.next != null) 
			{
				current = current.next;
			}
			System.out.println("Removed element :" + current.next.data);
			current.next = null;
		}
	}

	/**
	 * searching the item
	 */
	public boolean search(T item) 
	{

		Node current = head;
		if (head.data.equals(item)) 
		{
			return true;
		}
		while (current.next != null) 
		{
			current = current.next;
			if (current.data == item || current.data.equals(item)) 
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * remove a particular item
	 */
	public void removeItem(T item)
	{
		Node current=head;
		Node prev=null;
		if(head==null)
		{
			System.out.println("List is empty..!!");
			return;
		}
		if(head.data.equals(item))
		{
			head = head.next;
		}
		else
		{
			while(current.next!=null)
			{
				if(current.data.equals(item))
				{
					System.out.println("Removed : "+current.data);
					prev.next=current.next;
					return;
				}
				prev=current;
				current=current.next;
			}
		}
	}

	public boolean isEmpty() 
	{
		return head == null;
	}

	public T pop(int pos)
	{
		Node current = head;
		Node prev = null;
		T data = null;
		if(pos == 0)
		{
			data = (T) head.data;
			head = head.next;
			return (T) data;
		}
		for(int i = 0; i < pos; i++)
		{
			prev = current;
			current = current.next;
		}
		prev.next=current.next.next;
		return current.data;


	}

	/**
	 * Size of the list
	 */
	public int size() 
	{
		Node current = head;
		int size = 0;
		if (head == null) 
		{
			System.out.println("list is empty");
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
	 * Adding the node in last of list
	 */
	public void append(T data) 
	{
		Node node = new Node(data);
		Node current = head;
		if (head == null) 
		{
			head = node;
		}
		while (current.next != null) 
		{
			current = current.next;
		}
		current.next = node;

	}

	/**
	 * Returns the position of item.
	 */
	public int index(T item) 
	{
		int index = 0;
		Node current = head;
		if (head == item) 
		{
			return index;
		}
		while (current.next != null) 
		{
			index++;
			current = current.next;
			if (current.data == item || current.data.equals(item)) 
			{
				return index;
			}
		}
		return -1;
	}

	/**
	 * Inserting the item in position
	 */
	public void insert(int pos, T data) 
	{
		Node node = new Node(data);
		Node current = head;
		if (pos == 0) 
		{
			head = node;
		} 
		else
			for (int i = 0; i < pos-1; i++) 
			{
				current = current.next;
			}
		node.next = current.next;
		current.next = node;
	}


	/**
	 * Displaying the output
	 */
	public void display() 
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
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println(current.data);
		}
	}
}