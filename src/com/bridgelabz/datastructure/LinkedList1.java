package com.bridgelabz.datastructure;

import com.bridgelabz.utility.InputUtility;

class Node1
{
	int data;
	Node1 next;
	
	public Node1(int d)
	{
		data = d;
		next = null;
	}
}

class LinkedListFunction
{
	private int size = 0;
	private Node1 head;
	
	//check if the List is empty or not
	
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}
	
	//Return the size of the list
	
	public int listSize()
	{
		Node1 current = head;

		int size = 0;

		if (head == null) {

			System.out.println("list is empty");

		} else {

			while (current.next != null) {

				size++;

				current = current.next;

			}

		}
		return size;
	}
	
	//Insert into LinkedList
	public void insert(int data)
	{
		Node1 node = new Node1(data);
		Node1 temp = head;
		
		if(head == null)
			head = node;
		else
		{
			while(temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = node;
			size++;
		}
	}
	
	//Method to insert items at first position
	
	public void insertAtFirst(int data)
	{
		Node1 node = new Node1(data);
		if(head == null)
			head = node;
		else
		{
			node.next = head;
			head = node;
			size++;
		}
		
	}
	
	//Method to insert at last position
	
	public void insertAtLast(int data)
	{
		Node1 node = new Node1(data);
		Node1 temp = head;
		if(head == null)
			head = node;
		else
		{
			while(temp.next != null)
				temp = temp.next;
			temp.next = node;
			size++;
		}
	}
	
	public void insertAtPosition(int data, int pos)
	{
		
		if(pos == 1)
			insertAtFirst(data);
		else if(pos == size+1)
			insertAtLast(data);
		else if(pos > 1 && pos <= size)
		{
			Node1 node = new Node1(data);
			Node1 temp = head;
			
			for(int i = 1; i < pos-1; i++)
				temp = temp.next;
			
			node.next = temp.next;
			temp.next = node;
			size++;
		}
		else
			System.out.println("Invalid Position");
		
	}
	
	//Method to Print the LinkedList
	
	public void printList()
	{
		Node1 temp = head;
		if(isEmpty())
			System.out.println("List is EMpty");
		else
		{
//			for (int i = 0; i <= size; i++)
//			{
//				System.out.print(temp.data+" ");
//				temp = temp.next;
//
//			}
			while(temp != null)
			{
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			
			System.out.println();
		}
	}
	
}

public class LinkedList1 
{
	

	public static void main(String[] args) 
	{
		LinkedListFunction list = new LinkedListFunction();
		
		System.out.println("How many items do u want to insert into the list: ");
		int totalItem = InputUtility.inputInteger();
		System.out.println("Enter Items");
		
		for(int i = 0; i < totalItem; i++)
			list.insert(InputUtility.inputInteger());
		
		System.out.println("SIze = " +(list.listSize()+1));
		System.out.print("List: " );
		list.printList();
		
		list.insertAtFirst(9);
		System.out.print("List: " );
		list.printList();
		System.out.println("SIze = " +(list.listSize()+1));
		
		list.insertAtLast(20);
		System.out.print("List: " );
		list.printList();
		System.out.println("SIze = " +(list.listSize()+1));
		
		System.out.println("Insert Position");
		int pos = InputUtility.inputInteger();
		System.out.println("Enter value");
		int item = InputUtility.inputInteger();
		list.insertAtPosition(item, pos);
		System.out.println();
		System.out.print("List: " );
		list.printList();
		System.out.println("SIze = " +(list.listSize()+1));
	}

}
